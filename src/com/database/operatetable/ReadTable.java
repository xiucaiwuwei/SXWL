package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.LinkSQL.*;

public class ReadTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    private static Vector<Vector<Object>> Read(String sql) {
        Vector<Vector<Object>> datas = new Vector<>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector<Object> data = new Vector<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    data.add(resultSet.getObject(i));
                }
                datas.add(data);
            }
            return datas;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection, statement, resultSet);
        }
    }

    public static Vector<Vector<Object>> readTable(String table) {
        String sql = "select * from "+table;
        return Read(sql);
    }
    public static Vector<Vector<Object>> QueryTable(String table,String id) {
        String sql = "select * from " + table + " where id=" + id;
        return Read(sql);
    }
}
