package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static com.database.LinkSQL.*;
import static com.database.operatetable.ReadTable.readTable;

public class operatecustom {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    /**
     * 更新客户信息。
     * 通过SQL语句更新数据库中的客户账户、密码、电话、地址1、地址2等信息。
     * 使用预编译的SQL语句来提高性能和安全性。
     *
     * @param data 包含待更新客户信息的Vector，其中元素顺序与SQL语句中的占位符顺序对应。
     */
    public static void updatecustom(Vector<Object> data){
        String sql = "update custom set account=?,password = ?, phone = ?, address1 = ?, address2 = ? where account = ?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < 5; i++) {
                statement.setString(i+1, String.valueOf(data.get(i)));
            }
            statement.setString(6, String.valueOf(readTable("temporary").get(0).get(0)));
            statement.executeUpdate();
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
            statement.setString(1, String.valueOf(readTable("temporary").get(0).get(0)));
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


}
