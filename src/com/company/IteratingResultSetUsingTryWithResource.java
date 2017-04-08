package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vasiliy on 07.04.2017.
 */

public class IteratingResultSetUsingTryWithResource {


    public static void main(String[] args) throws SQLException {

        try {
            Connection conn = DBUtil.getConnection(DBType.ORACLE);
            System.out.println("Connection was successfully established!");//why?
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = stmt.executeQuery("SELECT * from COUNTRY");
            //String format = "%-4s%-10f%\n";
            while (res.next()) {
                System.out.println(res.getString("NAME") + " has " + res.getString("CITIZENS") + " citizens\t");
                //System.out.format(format, res.getString("NAME"), res.getString("CITIZENS"));
            }
            res.last();
            System.out.println("Total Rows: " + res.getRow());
        } catch (SQLException ex) {
            DBUtil.showErrorMessage(ex);
        }
    }
}
