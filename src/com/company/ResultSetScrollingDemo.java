package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vasiliy on 07.04.2017.
 */
public class ResultSetScrollingDemo {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DBUtil.getConnection(DBType.ORACLE);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("select* from Country where rownum<=3");

        ) {
            rs.beforeFirst();
            System.out.println("First 3 rows: ");
            while (rs.next()) {
                System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
            }

            rs.afterLast();
            System.out.println("Last 3 rows");
            while (rs.previous()) {
                System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
            }

            rs.first();
            System.out.println("First row:");
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");

            rs.last();
            System.out.println("Last record:");
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
            rs.absolute(2);
            System.out.println("2d absolute row  record:");
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
            rs.relative(1);
            System.out.println(" 1st relative row  record:");
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");

            rs.relative(-2);
            System.out.println("Record in 2d row :");
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
        }catch (SQLException ex){
            DBUtil.showErrorMessage(ex);
        }
    }
}
