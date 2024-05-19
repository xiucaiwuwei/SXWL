package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class inspection {
    public static boolean validate(String sql, String account1, String password1){
        try {
            Connection connection = linksql.getconnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            boolean mate = false;
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()) {
                String account2 = resultSet.getNString(1);
                String password2 = resultSet.getNString(2);
                if (account1.equals(account2) && password1.equals(password2)) {
                    mate = true;
                }
            }
            linksql.closesql(connection,statement,resultSet);
            return mate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void valitemp(String account, String password){
        String sql = "insert into temporary(account, password) VALUE (?,?)";
        Connection connection = linksql.getconnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,account);
            statement.setString(2,password);
            statement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        linksql.closesql(connection,statement,null);
    }
    public static void closetemp(){
        String sql = "truncate temporary";
        Connection connection = linksql.getconnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        linksql.closesql(connection,statement,null);
    }
}
