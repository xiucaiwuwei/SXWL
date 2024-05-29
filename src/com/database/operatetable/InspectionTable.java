package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getconnection;

public class InspectionTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static boolean Inspection(String sql) {
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            return statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, null);
        }
    }

    public static boolean InspectionAccount(String table, String id) {
        String sql = "select * from " + table + " where account=" + id;
        return Inspection(sql);
    }

    public static boolean InspectionAccount(String table, String id, String password) {
        String sql = "select * from " + table + " where id=" + id + " and password=" + password;
        return Inspection(sql);
    }
}
