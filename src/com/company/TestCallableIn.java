package com.company;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Vasiliy on 11/04/2017.
 */
public class TestCallableIn {
    //store procedures
    public static void main(String[] args) {
        try(
                Connection conn = DBUtil.getConnection(DBType.ORACLE);

                CallableStatement callableStatement = conn.prepareCall("{call AddNewCounry(?,?)}")
        ) {
            int quant;
            String countryName;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter quantity:");

            quant = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter country name: ");
            countryName = scanner.nextLine();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
