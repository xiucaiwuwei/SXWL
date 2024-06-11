package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class UpdateTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    public static void ModifyStaff(String password) {
        String sql ="update staff set password=? where id=?";
        ModifyPassword(sql,password);
    }
    public static void ModifyCustom(String password) {
        String sql ="update custom set password=? where id=?";
        ModifyPassword(sql,password);
    }
    public static void ModifyAdministrators(String password) {
        String sql ="update administrators set password=? where id=?";
        ModifyPassword(sql,password);
    }
    private static void ModifyPassword(String sql, String password) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,password);
            statement.setString(2,ReadTable.ReadTemporary().get(0));
            statement.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,null);
        }
        ModifyTemp(ReadTable.ReadTemporary().get(0),password);
    }

    public static void ModifyTemp(String id, String password) {
        String sql = "update temporary set id=?,password=? where id=?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            statement.setString(2,password);
            statement.setString(3,ReadTable.ReadTemporary().get(0));
            statement.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,null);
        }
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
        String sql = "update staff set id=?, name=?,gender=?, age=?,date=?,position=?,phone=?,password=? where id = ?";
        Update(sql,data);
    }

    public static void UpdateGoods(Vector<String> data){
        String sql = "update goods set id=?,name=?,number=?,consignee=?,phone=?,paymenttime=?,deliverytime=?,address=?,notes=?,way=?,photo=?,custom=?,staff=?,receiptstatus=?,signingtime=? where id=?";
        Update(sql,data);
    }

    public static void UpdateCustom(Vector<String> data){
        String sql = "update custom set id=?,password = ?,name=?, phone = ?, address1 = ?, address2 = ? where id = ?";
        Update(sql,data);
    }

    public static void UpdateGoodsCustom(Vector<String> data){
        String sql = "update goods set id=?,name=?,number=?,consignee=?,phone=?,address=?,paymenttime=?,deliverytime=?,notes=?,way=? where id=?";
        Update(sql,data);
    }

    public static void UpdateGoodsStaff(Vector<String> data){
        String sql = "update goods set id=?,deliverytime=?,putawayname=?,phone=?,address=?,notes=?,way=?,receiptstatus=?,signingtime=? where id=?";
        Update(sql,data);
    }
    public static void UpdateWages(Vector<String> data){
        String sql = "update wages set id=?, name=?, basicsalary=?, beonthejob=?, salariespayable=?, monthlybonus=?, deductiblesalary=?, netsalary=?, notes=? where id=?";
        Update(sql,data);
    }

}
