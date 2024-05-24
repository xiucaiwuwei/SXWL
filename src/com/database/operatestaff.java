package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class operatestaff {
    private static final Connection connection = linksql.getconnection();
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    public static Vector<Vector<Object>> readstaffs() {
        Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
        String sql = "select * from staff";
        try {
            connection.setCatalog("sxdate");
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
            linksql.closesql(connection,statement,resultSet);
        }
    }
}
