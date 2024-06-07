package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class IncreaseTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static boolean Increase(String sql, Vector<String> data) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < data.size(); i++) {
                statement.setString(i + 1, data.get(i));
            }
            return statement.execute();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            closesql(connection, statement, null);
        }
    }

    public static void IncreaseCustom(Vector<String> data) {
        String sql = "insert into custom(account, password, phone, address1, address2) values(?,?,?,?,?)";
        Increase(sql, data);
    }

    public static boolean IncreaseStaff(Vector<String> data) {
        String sql = "insert into staff(id, name, gender, age, date, position, phone, account, password) values(?,?,?,?,?,?,?,?,?)";
        return Increase(sql, data);
    }

    public static boolean IncreaseGoods(Vector<String> data) {
        String sql = "insert into goods(id, name, number, putawayname, phone, address, paymenttime, deliverytime, notes, way, photo, custom, staff, receiptstatus, signingtime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return Increase(sql, data);
    }

    public static boolean IncreaseWages(Vector<String> data) {
        String sql = "insert into wages(id, name, basicsalary, beonthejob, salariespayable, monthlybonus, deductiblesalary, netsalary, notes) values(?,?,?,?,?,?,?,?,?)";
        return Increase(sql, data);
    }

    public static void IncreaseTemporary(Vector<String> data) {
        String sql = "insert into temporary(account, password, selecttable) values(?,?,?)";
        Increase(sql, data);
    }
}
