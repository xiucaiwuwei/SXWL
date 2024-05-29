package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.LinkSQL.*;

public class operategoods {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static void updategoodsstaff(Vector<Object> data){
        String sql = "update goods set id=?,deliverytime=?,putawayname=?,phone=?,address=?,notes=?,way=?,receiptstatus=?,signingtime=? where id=?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < data.size(); i++) {
                statement.setString(i + 1, String.valueOf(data.get(i)));
            }
            statement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection, statement, resultSet);
        }
    }
    public static void updategoods(Vector<Object> data){
        String sql = "update goods set id=?,name=?,number=?,putawayname=?,phone=?,paymenttime=?," +
                "deliverytime=?,address=?,notes=?,way=? where id=?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < data.size(); i++) {
                statement.setString(i + 1, String.valueOf(data.get(i)));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection, statement, resultSet);
        }
    }
    /**
     * 读取账户信息。
     *
     * @return 包含账户信息的二维Vector对象。
     */
    public static Vector<Vector<Object>> selectcustom(String custom) {
        Vector<Vector<Object>> datas = new Vector<>();
        String sql = "select * from goods where custom=?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, custom);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                for (int j = 0; j < 15; j++) {
                    data.add(resultSet.getString(j + 1));
                }
                datas.add(data);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }

    /**
     * 从数据库中读取指定员工的货物信息。
     *
     * @param staff 员工标识，用于查询特定员工的货物信息。
     * @return 返回一个二维Vector，其中每个内部Vector代表一条货物信息，包含货物的各种属性。
     */
    public static Vector<Vector<Object>> selectstaff(String staff) {
        Vector<Vector<Object>> datas = new Vector<>();
        String sql = "select id,deliverytime,putawayname,phone,address,notes,way," +
                "receiptstatus,signingtime from goods where staff=?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, staff);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                for (int i = 0; i < 9; i++) {
                    data.add(resultSet.getString(i + 1));
                    if (i == 6) {
                        if (resultSet.getString(i + 1).equals("0")) {
                            data.set(i, "");
                        } else {
                            data.set(i, "货到付款");
                        }
                    }
                    if (i == 7) {
                        if (resultSet.getString(i + 1).equals("0")) {
                            data.set(i, "未签收");
                        } else {
                            data.set(i, "已签收");
                        }
                    }
                }
                datas.add(data);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }
}
