package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class linksql {
    private static String Driver;
    private static String URL;
    private static String username;
    private static String password;

    public static Connection getconnection() {
        Connection connection;
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closesql(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDriver(String driver) {
        Driver = driver;
    }

    public static void setURL(String URL) {
        linksql.URL = URL;
    }

    public static void setUsername(String username) {
        linksql.username = username;
    }

    public static void setPassword(String password) {
        linksql.password = password;
    }
}
