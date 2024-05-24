package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class operatecustom {
    private static final Connection connection = linksql.getconnection();
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static Vector<Vector<Object>> readcustoms(){
        Vector<Vector<Object>> datas = new Vector<>();
        String sql = "select * from custom";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Vector<Object> data = new Vector<>();
                for (int i = 0; i < 5; i++) {
                    data.add(resultSet.getString(i+1));
                }
                datas.add(data);
            }
            return datas;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
    }
    /**
     * 导入自定义数据到数据库。
     * @param account 账户名，将被插入到数据库的账户列。
     * @param password 密码，将被插入到数据库的密码列。
     * 该方法不返回任何值。
     */
    public static void importcustom(String account,String password){
        String sql = "insert into custom(account,password) values(?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,account);
            statement.setString(2,password);
            statement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
    }
    /**
     * 从数据库中根据账号读取定制信息。
     *
     * @param account 用户的账号，用于查询对应的定制信息。
     * @return Vector<String> 如果查询到结果，返回一个包含定制信息的Vector字符串数组；如果没有查询到结果，返回null。
     */
    public static Vector<String> readcustom(String account){
        Vector<String> custom = new Vector<>();
        String sql = "select * from custom where account=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,account);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                for (int i = 0; i < resultSet.getFetchSize(); i++) {
                    custom.add(resultSet.getString(i+1));
                }
                return custom;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
    }

    /**
     * 根据账户名查询账户是否存在
     * @param account 要查询的账户名
     * @return 返回账户是否存在的布尔值，存在返回true，不存在返回false
     */
    public static boolean selectaccount(String account){
        String sql = "select account from custom where account=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,account);
            resultSet = statement.executeQuery();
            return resultSet.next();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
    }

}
