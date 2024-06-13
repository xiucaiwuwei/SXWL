package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class DeleteTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static void Delete(String id, String sql) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, null);
        }
    }

    public static void DeleteCustom(String id) {
        String sql = "delete from custom where id=?";
        Delete(id, sql);
    }

    public static void DeleteStaff(String id) {
        String sql = "delete from staff where id=?";
        Delete(id, sql);
    }

    public static void DeleteGoods(String id) {
        String sql = "delete from goods where id=?";
        Delete(id, sql);
    }

    public static void DeleteWages(String id) {
        String sql = "delete from wages where id=?";
        Delete(id, sql);
    }

    private static boolean UnconditionalDelete(String sql) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            int i = statement.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, null);
        }
    }

    public static boolean DeleteSigned() {
        String sql = "delete from goods where receiptstatus=1";
        return UnconditionalDelete(sql);
    }

    public static void DeleteTemporary() {
        String sql = "truncate temporary";
        UnconditionalDelete(sql);
    }
}

