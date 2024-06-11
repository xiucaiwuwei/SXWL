package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;
import static com.database.operatetable.ReadTable.readTable;

public class SelectTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static Vector<Vector<String>> SelectCustom(String custom) {
        Vector<Vector<String>> datas = new Vector<>();
        String sql = "select id, name, number, consignee, phone, address, paymenttime, deliverytime, notes, way from goods where custom=?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, custom);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<String> data = new Vector<>();
                for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                    data.add(resultSet.getString(i + 1));
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
    public static Vector<Vector<Object>> selectstaff(String staff) {
        Vector<Vector<Object>> datas = new Vector<>();
        String sql = "select id,deliverytime,consignee,phone,address,notes,way," +
                "receiptstatus,signingtime from goods where staff=?";
        try {
            connection = getConnection();
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

    public static Vector<Object> selectid(String id){
        Vector<Object> data = new Vector<>();
        String sql ="select * from goods where custom=? and id=?";
        try {
            connection = getConnection();
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

