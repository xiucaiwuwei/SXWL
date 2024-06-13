package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class InspectionTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    private static boolean InspectionID(String sql, String id) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
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

    public static boolean InspectionStaffPassword(String id, String password) {
        String sql = "select * from staff where id=? and password=?";
        return InspectionPassword(sql, id, password);
    }

    public static boolean InspectionAdministratorsPassword(String id, String password) {
        String sql = "select * from administrators where id=? and password=?";
        return InspectionPassword(sql, id, password);
    }
    public static boolean InspectionCustomPassword(String id, String password) {
        String sql = "select * from custom where id=? and password=?";
        return InspectionPassword(sql, id, password);
    }

    private static boolean InspectionPassword(String sql,String id, String password) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }
}
