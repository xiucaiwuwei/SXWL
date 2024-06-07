package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LinkSQL {

    private static String Driver;
    private static String URL;
    private static String username;
    private static String password;

    /**
     * 获取数据库连接。如果出现异常，将抛出运行时异常。
     *
     * @return 数据库连接对象
     */
    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * 关闭数据库资源。按顺序关闭ResultSet、Statement和Connection，确保所有资源被正确释放。
     *
     * @param connection 数据库连接对象
     * @param statement  SQL语句对象
     * @param resultSet  查询结果集
     */
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

    /**
     * 设置数据库驱动类名。
     *
     * @param driver 数据库驱动全限定类名
     */
    public static void setDriver(String driver) {
        Driver = driver;
    }

    /**
     * 设置数据库连接的URL。
     *
     * @param URL 数据库连接URL
     */
    public static void setURL(String URL) {
        LinkSQL.URL = URL;
    }

    /**
     * 设置连接数据库所需的用户名。
     *
     * @param username 数据库用户名
     */
    public static void setUsername(String username) {
        LinkSQL.username = username;
    }

    /**
     * 设置连接数据库所需的密码。
     *
     * @param password 数据库密码
     */
    public static void setPassword(String password) {
        LinkSQL.password = password;
    }
}
