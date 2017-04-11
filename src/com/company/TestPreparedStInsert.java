package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Vasiliy on 11/04/2017.
 */
public class TestPreparedStInsert {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getConnection(DBType.ORACLE);

        int quant;
        String countryName;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quantity:");

        quant = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter country name: ");
        countryName = scanner.nextLine();

        String sql = "Insert into Country values(?,?)";
        PreparedStatement prstmt = conn.prepareStatement(sql);
        prstmt.setInt(2, quant);
        prstmt.setString(1, countryName);

        int result = prstmt.executeUpdate();
        if (result == 1) {
            System.out.println("Record inserted successfully");
        } else {
            System.err.println("Error while inserting record");
            ;
        }

        scanner.close();
        prstmt.close();
        conn.close();
    }
}

