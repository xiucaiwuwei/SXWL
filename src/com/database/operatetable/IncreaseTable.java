package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class IncreaseTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static void Increase(String sql, Vector<String> data) {
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < data.size(); i++) {
                statement.setString(i + 1, data.get(i));
            }
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            closesql(connection, statement, null);
        }
    }

    public static void IncreaseCustom(Vector<String> data) {
        String sql = "insert into custom(id, password, name,phone, address1, address2) values(?,?,?,?,?)";
        Increase(sql, data);
    }

    public static void IncreaseStaff(Vector<String> data) {
        String sql = "insert into staff(id, name, gender, staff.age, date, position, phone, password) values(?,?,?,?,?,?,?,?)";
        Increase(sql, data);
    }

    public static void IncreaseGoods(Vector<String> data) {
        String sql = "insert into goods(id, name, number, consignee, phone, address, paymenttime, deliverytime, notes, way, photo, custom, staff, receiptstatus, signingtime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Increase(sql, data);
    }

    public static void IncreaseWages(Vector<String> data) {
        String sql = "insert into wages(id, name, basicsalary, beonthejob, salariespayable, monthlybonus, deductiblesalary, netsalary, notes) values(?,?,?,?,?,?,?,?,?)";
        Increase(sql, data);
    }

    public static void IncreaseTemporary(Vector<String> data) {
        String sql = "insert into temporary(id, password, selecttable) values(?,?,?)";
        Increase(sql, data);
    }

    public static void IncreaseGoodsCustom(Vector<String> data) {
        String sql = "insert into goods(id, name, number, goods.consignee, phone, address, paymenttime, deliverytime, notes,way, custom,goods.staff) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Increase(sql, data);
    }
}
