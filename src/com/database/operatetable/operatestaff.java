package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.LinkSQL.*;

public class operatestaff {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static void updatestaff(Vector<String> data) {
        String sql = "update staff set id= ?,name = ?, gender= ?,age = ?,date= ?,position = ?,phone = ?,account = ?,password = ? where id = ?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < data.size(); i++) {
                statement.setString(i+1,data.get(i));
            }
            statement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
