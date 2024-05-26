package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static com.database.linksql.*;

public class operatetemp {

    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static void updatetemp(String account, String password, int select) {
        String sql = "update temporary set account=?,password=?,selecttable=? where account=?";
        String accounted = readtemp().get(0);
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, account);
            statement.setString(2, password);
            statement.setInt(3, select);
            statement.setString(4,accounted);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }
    /**
     * 从数据库中读取临时表的数据。
     */
    public static Vector<String> readtemp() {
        Vector<String> data = new Vector<>();
        String sql = "select * from temporary";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            resultSet.next();
            data.add(resultSet.getString(1));
            data.add(resultSet.getString(2));
            data.add(resultSet.getString(3));
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }

    /**
     * 将账户信息存入临时表。
     *
     * @param account  用户账户名。
     * @param password 用户密码。
     * @param select   选择的表。
     */
    public static void importtemp(String account, String password, int select) {
        String sql = "insert into temporary(account, password,selecttable) VALUE (?,?,?)";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, account);
            statement.setString(2, password);
            statement.setInt(3, select);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }

    /**
     * 清空临时表中的所有数据。
     */
    public static void emptytemp() {
        String sql = "truncate temporary";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closesql(connection, statement, resultSet);
        }
    }

}