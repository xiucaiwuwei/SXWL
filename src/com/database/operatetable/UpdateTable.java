package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;
import static com.database.operatetable.ReadTable.readTable;

public class UpdateTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static void Modify(String sql) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,null);
        }
    }
    public static void ModifyPassword(String table, String password) {
        String sql ="update "+table+" set password="+password+" where account="+ReadTable.readTable("temporary").get(0).get(0);
        Modify(sql);
    }

    public static void ModifyTemp(String account, String password) {
        String sql = "update temporary set account="+account+",password="+password+" where account="+ReadTable.readTable("temporary").get(0).get(0);
        Modify(sql);
    }

    private static void Update(String sql, Vector<String> data) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < data.size(); i++) {
                statement.setString(i+1,data.get(i));
            }
            statement.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void UpdateStaff(Vector<String> data) {
        String sql = "update staff set id= ?,name = ?, gender= ?,age = ?,date= ?,position = ?,phone = ?,account = ?,password = ? where id = ?";
        Update(sql,data);
    }

    public static void UpdateGoods(Vector<String> data){
        String sql = "update goods set id=?,name=?,number=?,putawayname=?,phone=?,paymenttime=?,deliverytime=?,address=?,notes=?,way=? where id=?";
        Update(sql,data);
    }

    public static void UpdateCustom(Vector<String> data){
        String sql = "update custom set account=?,password = ?, phone = ?, address1 = ?, address2 = ? where account = ?";
        Update(sql,data);
    }

    public static void UpdateGoodsStaff(Vector<String> data){
        String sql = "update goods set id=?,deliverytime=?,putawayname=?,phone=?,address=?,notes=?,way=?,receiptstatus=?,signingtime=? where id=?";
        Update(sql,data);
    }

}
