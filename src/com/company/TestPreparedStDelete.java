package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Vasiliy on 11/04/2017.
 */
public class TestPreparedStDelete {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getConnection(DBType.ORACLE);
        String sql = "Delete from country where name = ?";

        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of the country you want to delete:");
        name = scanner.nextLine();

        PreparedStatement prstmt = conn.prepareStatement(sql);
        prstmt.setString(1, name);

        int result = prstmt.executeUpdate();
        if (result == 1) {
            System.out.println("The row was deleted successfully");
        } else {
            System.err.println("Error during removing ");
        }
        scanner.close();
        prstmt.close();
        conn.close();
    }
}
