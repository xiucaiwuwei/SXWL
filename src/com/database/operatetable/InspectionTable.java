package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class InspectionTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static boolean InspectionID(String sql, String id) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closesql(connection, statement, null);
        }
    }
    public static boolean InspectionCustomID(String id) {
        String sql = "select * from custom where id=?";
        return InspectionID(sql, id);
    }

    public static boolean InspectionStaffID(String id) {
        String sql = "select * from staff where id=?";
        return InspectionID(sql, id);
    }

    public static boolean InspectionGoodsID(String id) {
        String sql = "select * from goods where id=?";
        return InspectionID(sql, id);
    }

    public static boolean InspectionWagesID(String id) {
        String sql = "select * from wages where id=?";
        return InspectionID(sql, id);
    }
    public static boolean InspectionAccount(String table, String id, String password) {
        String sql = "select * from "+table+" where id=? and password=?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, table);
            statement.setString(2, id);
            statement.setString(3, password);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closesql(connection, statement, null);
        }
    }
}
