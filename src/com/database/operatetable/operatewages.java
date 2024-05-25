package com.database.operatetable;

import com.database.operatetable.operatetemp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static com.database.linksql.*;

public class operatewages {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    public static Vector<Object> readwages()
    {
        String sql = "select * from wages where id =?";
        Vector<Object> data = new Vector<>();
        try
        {
            connection = getconnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, operatetemp.readtemp().get(0));
            resultSet = statement.executeQuery();
            resultSet.next();
            for (int i = 0; i < 9; i++) {
                data.add(resultSet.getString(i+1));
            }
            return data;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            closesql(connection,statement,resultSet);
        }
    }
}
