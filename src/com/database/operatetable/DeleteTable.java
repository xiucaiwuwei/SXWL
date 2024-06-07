package com.database.operatetable;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.database.LinkSQL.closesql;
import static com.database.LinkSQL.getConnection;

public class DeleteTable {
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    private static boolean Delete(String sql) {
        try {
            // 获取数据库连接。
            connection = getConnection();
            // 创建预处理语句。
            statement = connection.prepareStatement(sql);
            // 执行SQL删除操作并返回执行结果。
            return statement.execute();
        } catch (Exception e) {
            // 如果发生异常，则抛出运行时异常。
            throw new RuntimeException(e);
        } finally {
            // 无论操作是否成功，都关闭数据库连接和预处理语句。
            closesql(connection, statement, null);
        }
    }

    public static boolean deleteTable(String table, String id) {
        String sql = "delete from " + table + " where id=" + id;
        if (table.equals("temporary")) {
            sql = "truncate temporary";
        }
        return Delete(sql);
    }
}

