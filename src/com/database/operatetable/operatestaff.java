package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.linksql.*;

public class operatestaff {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    public static Vector<Vector<Object>> readstaffs() {
        Vector<Vector<Object>> datas = new Vector<>();
        String sql = "select * from staff";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                for (int i = 0; i < 9; i++) {
                    data.add(resultSet.getString(i+1));
                }
                datas.add(data);
            }
            return datas;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }
    public static boolean deletestaff(String id) {
        String sql = "delete from staff where id = ?";
        try {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            return statement.executeUpdate()>0;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }
}
