package com.database;

import com.database.operatetable.*;

import java.sql.*;

import static com.database.LinkSQL.*;

/**
 * 数据库操作类，提供了一系列静态方法用于账户信息的读取、验证和存储等操作。
 */
public class inspection {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    /**
     * 修改指定表中的密码。
     * @param table 表名，需要修改密码的表。
     * @param password 新密码，将要设置的密码。
     * 注意：此方法不返回任何值，但会在指定的表中更新密码字段。
     */
    public static void modifypassword(String table,String password) {
        String sql ="update "+table+" set password=? where account=?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,password); // 设置新密码
            statement.setString(2, String.valueOf(ReadTable.readTable("temporary").get(0).get(0))); // 设置账户名，通常是从当前登录用户读取
            statement.executeUpdate(); // 执行更新操作
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }
}
