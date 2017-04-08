package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vasiliy on 07.04.2017.
 */
public class DBUtil {
    private static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String username = "system";
    private static final String password = "root";

    public static Connection getConnection(DBType type) throws SQLException {
        switch (type) {
            case ORACLE:
                return DriverManager.getConnection(dbUrl, username, password);

            default:
                return null;
        }
    }

    public static void showErrorMessage(SQLException ex) {
        System.err.println("Error: " + ex.getMessage());
        System.err.println("Code: " + ex.getErrorCode());
    }
}
