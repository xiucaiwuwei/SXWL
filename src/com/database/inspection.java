package com.database;

import java.sql.*;

/**
 * 数据库操作类，提供了一系列静态方法用于账户信息的读取、验证和存储等操作。
 */
public class inspection {

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
            statement.setString(2,operatetemp.readtemp().get(0)); // 设置账户名，通常是从当前登录用户读取
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

}
