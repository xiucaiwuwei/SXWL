package com.database;

import java.sql.*;
import java.util.Vector;

/**
 * 数据库操作类，提供了一系列静态方法用于账户信息的读取、验证和存储等操作。
 */
public class inspection {
    /**
     * 从数据库中读取指定员工的货物信息。
     * @param staff 员工标识，用于查询特定员工的货物信息。
     * @return 返回一个二维Vector，其中每个内部Vector代表一条货物信息，包含货物的各种属性。
     */
    public static Vector<Vector<Object>> readgoods(String staff) {
        // 初始化用于存储数据的向量
        Vector<Vector<Object>> datas = new Vector<>();
        // 构造SQL查询语句，使用参数化查询以避免SQL注入
        String sql = "select id,deliverytime,putawayname,phone,address,notes,way," +
                "receiptstatus,signingtime from goods where staff=?";
        // 获取数据库连接
        Connection connection = linksql.getconnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            // 准备执行SQL语句，设置查询参数
            statement = connection.prepareStatement(sql);
            statement.setString(1,staff);
            // 执行查询，获取结果集
            resultSet = statement.executeQuery();
            // 遍历结果集，将每条数据存储到一个Vector中，然后将这个Vector添加到datas中
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                for (int i = 0; i < 9; i++) {
                    data.add(resultSet.getString(i+1));
                    if(i==6){
                        if (resultSet.getString(i+1).equals("0")){
                            data.set(i, "");
                        }else {
                            data.set(i, "货到付款");
                        }
                    }
                    if(i==7){
                        if (resultSet.getString(i+1).equals("0")){
                            data.set(i, "未签收");
                        }else {
                            data.set(i, "已签收");
                        }
                    }
                }
                datas.add(data);
            }
            return datas;
        }catch (Exception e){
            // 捕获并抛出运行时异常，方便调用方处理
            throw new RuntimeException(e);
        }finally {
            // 无论是否发生异常，最后都关闭数据库连接、PreparedStatement和ResultSet
            linksql.closesql(connection,statement,resultSet);
        }

    }
    /**
     * 修改指定表中的密码。
     * @param table 表名，需要修改密码的表。
     * @param password 新密码，将要设置的密码。
     * 注意：此方法不返回任何值，但会在指定的表中更新密码字段。
     */
    public static void modifypassword(String table,String password) {
        // 构造更新密码的SQL语句
        String sql ="update "+table+" set password=? where account=?";
        Connection connection = linksql.getconnection(); // 获取数据库连接
        PreparedStatement statement=null;
        try {
            // 准备执行SQL语句，设置参数
            statement = connection.prepareStatement(sql);
            statement.setString(1,password); // 设置新密码
            statement.setString(2,readaccount()); // 设置账户名，通常是从当前登录用户读取
            statement.executeUpdate(); // 执行更新操作
        }catch (SQLException e){
            // 捕获并抛出SQL异常
            throw new RuntimeException(e);
        }finally {
            // 确保资源被正确关闭
            linksql.closesql(connection,statement,null);
        }
    }
    /**
     * 从临时表中读取密码。
     * 此方法不需要传入任何参数，它将查询临时表中的密码信息，并返回包含密码的字符串向量。
     * @return 返回一个Vector<String>类型，其中包含了从临时表中查询到的密码信息。
     */
    public static Vector<String> readpassword(){
        // 准备查询语句
        String sql ="select password,selecttable from temporary";
        Connection connection = linksql.getconnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Vector<String> data = new Vector<>();
        try {
            // 执行查询
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            resultSet.next();
            // 将查询结果添加到向量中
            data.add(resultSet.getString(1));
            data.add(resultSet.getString(2));
            return data;
        }
        catch (SQLException e) {
            // 捕获并抛出SQL异常
            throw new RuntimeException(e);
        }finally {
            // 释放资源
            linksql.closesql(connection,statement,resultSet);
        }
    }
    /**
     * 从临时表中读取账户名。
     * @return 账户名字符串。
     */
    public static String readaccount(){
        String account;
        // 查询临时表中的账户名
        String sql ="select account from temporary";
        Connection connection = linksql.getconnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            resultSet.next();
            account = resultSet.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
        return account;
    }

    /**
     * 读取指定字段的账户信息。
     * @param arrange 需要读取的字段数量。
     * @return 包含账户信息的二维Vector对象。
     */
    public static Vector<Vector<Object>> readdata(int arrange){
        Vector<Vector<Object>> datas = new Vector<>();
        // 查询goods表中所有字段，通过账户名过滤
        String sql ="select * from goods where custom=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement =connection.prepareStatement(sql);
            // 传入当前登录账户名
            statement.setString(1,readaccount());
            resultSet = statement.executeQuery();

            if (arrange <= 0) {
                throw new IllegalArgumentException("arrange must be a positive integer");
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (arrange > columnCount) {
                arrange = columnCount;
            }
            // 遍历结果集，并将数据存入Vector中
            while (resultSet.next()) {
                Vector<Object> data=new Vector<>();
                for (int j=0;j<arrange;j++){
                    data.add( resultSet.getObject(j + 1));
                }
                datas.add(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
        return datas;
    }

    /**
     * 对用户登录进行验证。
     * @param outside 表名前缀，用于区分不同类型的账户。
     * @param account 用户账户名。
     * @param password 用户密码。
     * @return 验证是否成功，成功返回true，失败返回false。
     */
    public static boolean validate(String outside, String account, String password){
        // 根据表名前缀和账户名、密码查询账户信息
        String sql = "select account,password from "+outside+" where account =? and password=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,account);
            statement.setString(2,password);
            resultSet=statement.executeQuery();
            // 如果查询结果存在，则验证成功
            return  resultSet.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
    }

    /**
     * 将账户信息存入临时表。
     * @param account 用户账户名。
     * @param password 用户密码。
     */
    public static void valitemp(String account, String password){
        // 向临时表中插入账户名和密码
        String sql = "insert into temporary(account, password) VALUE (?,?)";
        Connection connection = linksql.getconnection();
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,account);
            statement.setString(2,password);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,null);
        }
    }

    /**
     * 清空临时表中的所有数据。
     */
    public static void closetemp(){
        // 清空临时表
        String sql = "truncate temporary";
        Connection connection = linksql.getconnection();
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,null);
        }
    }
}
