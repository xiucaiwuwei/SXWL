package com.database;

import com.database.operatetable.operatetemp;

import java.sql.*;

import static com.database.linksql.*;

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
            statement.setString(2, operatetemp.readtemp().get(0)); // 设置账户名，通常是从当前登录用户读取
            statement.executeUpdate(); // 执行更新操作
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }

    /**
     * 对用户登录进行验证。
     * @param outside 表名前缀，用于区分不同类型的账户。
     * @param account 用户账户名。
     * @param password 用户密码。
     * @return 验证是否成功，成功返回true，失败返回false。
     */
    public static boolean validate(String outside, String account, String password){
        String sql = "select account,password from "+outside+" where account =? and password=?";
        try {
            connection = getconnection();
            statement=connection.prepareStatement(sql);
            statement.setString(1,account);
            statement.setString(2,password);
            resultSet=statement.executeQuery();
            return  resultSet.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }

}
