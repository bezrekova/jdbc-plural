package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Vasiliy on 08/04/2017.
 */
public class PreparedStatementDemo {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement prepstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection(DBType.ORACLE);
            String sql = "Select * from Country where Citizens<?";
            prepstmt = conn.prepareStatement(sql, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);

            prepareStatement(prepstmt,30000);
            System.out.println("---------------------------------------------------------");
            prepareStatement(prepstmt,500000);

        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
    }

    private static void prepareStatement(PreparedStatement prepstmt, int citznsQuantity) throws SQLException {
        ResultSet rs;
        prepstmt.setInt(1, citznsQuantity);
        rs = prepstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
        }

        rs.last();
        System.out.println("Total number: " + rs.getRow());
    }
}
