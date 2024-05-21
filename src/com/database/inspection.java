package com.database;

import java.sql.*;
import java.util.Vector;

public class inspection {
    //获得账户名
    private static String readaccount(){
        String account;
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
    //读取账户信息
    public static Vector<Vector<Object>> readdata(int arrange){
        Vector<Vector<Object>> datas = new Vector<>();
        String sql ="select * from goods where custom=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement =connection.prepareStatement(sql);
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
    //登录判断
    public static boolean validate(String outside, String account, String password){
        String sql = "select account,password from "+outside+" where account =? and password=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,account);
            statement.setString(2,password);
            resultSet=statement.executeQuery();
            return  resultSet.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
    }
    //将账户信息存到临时表
    public static void valitemp(String account, String password){
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
    //清空临时表
    public static void closetemp(){
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
