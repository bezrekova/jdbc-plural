package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vasiliy on 07.04.2017.
 */
public class ResultSetUpdate {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DBUtil.getConnection(DBType.ORACLE);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select* from Country");


        ) {
            rs.absolute(4);
            System.out.println("Old row; ");
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
            rs.updateInt("Citizens",211111);
            rs.updateRow();
            System.out.println("New row:");
            System.out.println(rs.getString("NAME") + " has " + rs.getString("CITIZENS") + " citizens\t");
            rs.moveToInsertRow();
            rs.updateString("Name", "Australia");
            rs.updateInt(2, 134444);
            rs.insertRow();
            System.out.println("Row was successfully inserted");
        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
    }
}
