package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.database.LinkSQL.*;

public class operatetemp {

    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static void updatetemp(String account, String password, int select) {
        String sql = "update temporary set account=?,password=?,selecttable=? where account=?";
        String accounted = String.valueOf(ReadTable.readTable("temporary").get(0).get(0));
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

}
