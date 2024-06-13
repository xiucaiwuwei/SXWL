package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

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
        String sql = "select id, consignee, phone, address, notes, way,receiptstatus,signingtime from goods where staff=?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, staff);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                    data.add(resultSet.getObject(i + 1));
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

    public static Vector<Object> selectid(String id) {
        Vector<Object> data = new Vector<>();
        String sql = "select * from goods where custom=? and id=?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, ReadTable.ReadTemporary().get(0));
            statement.setString(2, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                for (int i = 0; i < 11; i++) {
                    data.add(resultSet.getString(i + 1));
                }
                return data;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }

    public static Vector<Vector<Object>> selectgoodsstaff(String address) {
        String sql = "select id, consignee, phone, address, notes, way,receiptstatus,signingtime from goods where goods.staff = 1001 and address like '%" + address + "%'";
        return SelectNot(sql);
    }

    public static Vector<Vector<Object>> SelectUndistributed() {
        String sql = "select id, consignee, phone, address, notes, way,receiptstatus,signingtime from goods where goods.staff = 1001";
        return SelectNot(sql);
    }

    private static Vector<Vector<Object>> SelectNot(String sql) {
        Vector<Vector<Object>> datas = new Vector<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
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
}

