package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getconnection;

public class DeleteTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static boolean Delete(String sql) {
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

    public static boolean deleteTable(String table, String id) {
        String sql = "delete from " + table + " where id=" + id;
        if (table.equals("temporary")) {
            sql = "truncate temporary";
        }
        return Delete(sql);
    }
}

