package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Vasiliy on 11/04/2017.
 */
public class TestPreparedStUpdate {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getConnection(DBType.ORACLE);

        String sql = "Update Country set citizens = ? where name = ?";

        int citizens;
        String countryName;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new citizens quantity:");
        citizens = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter country name:");
        countryName = scanner.nextLine();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, citizens);
        preparedStatement.setString(2, countryName);

        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            System.out.println("The record was updated successfully");
        } else {
            System.err.println("Error during updating ");
        }
        scanner.close();
        preparedStatement.close();
        conn.close();
    }
}
