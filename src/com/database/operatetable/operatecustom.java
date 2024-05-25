package com.database.operatetable;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static com.database.linksql.*;

public class operatecustom {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static void updatecustom(Vector<String> data){
        String sql = "update custom set account=?,password = ?, phone = ?, address1 = ?, address2 = ? where account = ?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < 5; i++) {
                statement.setString(i+1, data.get(i));
            }
            statement.setString(6,operatetemp.readtemp().get(0));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            closesql(connection, statement, null);
        }
    }
    public static Vector<Object> selectid(String id){
        Vector<Object> data = new Vector<>();
        String sql ="select * from goods where custom=? and id=?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, operatetemp.readtemp().get(0));
            statement.setString(2,id);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                for (int i = 0; i < 11; i++) {
                    data.add(resultSet.getString(i+1));
                }
                return data;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }
    public static Vector<Vector<Object>> readcustoms(){
        Vector<Vector<Object>> datas = new Vector<>();
        String sql = "select * from custom";
        try {
            connection = getconnection();
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
            closesql(connection,statement,resultSet);
        }
    }

    /**
     * 将给定数据导入到 custom 表中。
     * @param data 包含要导入的数据的向量，其中每个元素按顺序对应于表中的列（account, password, phone, address1, address2）。
     */
    public static void importcustom(Vector<String> data){
        String sql = "insert into custom(account, password, phone, address1, address2) values(?,?,?,?,?)";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < 5; i++) {
                statement.setString(i+1,data.get(i));
            }
            statement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }
    /**
     * 从数据库中根据账号读取定制信息。
     *
     * @param account 用户的账号，用于查询对应的定制信息。
     * @return Vector<String> 如果查询到结果，返回一个包含定制信息的Vector字符串数组；如果没有查询到结果，返回null。
     */
    public static Vector<String> readcustom(String account){
        Vector<String> data = new Vector<>();
        String sql = "select * from custom where account=?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,account);
            resultSet = statement.executeQuery();
            resultSet.next();
            for (int i = 0; i < 5; i++) {
                data.add(resultSet.getString(i+1));
            }
            return data;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
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
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,account);
            resultSet = statement.executeQuery();
            return resultSet.next();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }

}
