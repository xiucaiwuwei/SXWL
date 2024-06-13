package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class ReadTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    private static Vector<Vector<Object>> Read(String sql) {
        Vector<Vector<Object>> datas = new Vector<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    data.add(resultSet.getObject(i));
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

    public static Vector<Vector<Object>> readTable(String table) {
        String sql = "select * from " + table;
        return Read(sql);
    }

    private static Vector<Object> Query(String sql, String id) {
        Vector<Object> data = new Vector<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    data.add(resultSet.getObject(i));
                }
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }

    public static Vector<Object> QueryCustom(String id) {
        String sql = "select * from custom where id=?";
        return Query(sql, id);
    }

    public static Vector<Object> QueryStaff(String id) {
        String sql = "select * from staff where id=?";
        return Query(sql, id);
    }

    public static Vector<Object> QueryGoods(String id) {
        String sql = "select * from goods where id=?";
        return Query(sql, id);
    }

    public static Vector<Object> QueryWages(String id) {
        String sql = "select * from wages where id=?";
        return Query(sql, id);
    }

    public static Vector<String> ReadTemporary() {
        String sql = "select * from temporary";
        Vector<String> data = new Vector<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            resultSet.next();
            data.add(resultSet.getString(1));
            data.add(resultSet.getString(2));
            data.add(resultSet.getString(3));
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }
}
