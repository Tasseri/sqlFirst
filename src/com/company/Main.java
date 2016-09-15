package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("connecting...");
        Scanner scan = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost;Database=LoginDB;IntegratedSecurity=true");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Posts")) {
            System.out.println("Success!\n");
            while (rs.next()) {
                System.out.printf("%s: %s\n",rs.getString("PostID"), rs.getString("PostTitle"));
            }
            System.out.println("\nChoose id of Post:");
            int myChoice = scan.nextInt();
            PreparedStatement ps2 = conn.prepareStatement("SELECT * " +
                    "FROM Posts as P " +
                    "INNER JOIN Blogg as B " +
                    "ON B.BloggID = P.Blogg_ID " +
                    "INNER JOIN Users as U " +
                    "ON U.UserID = B.User_ID " +
                    "WHERE PostID = ?; ");
            ps2.setInt(1, myChoice);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()) {
                System.out.printf("Title: %s\nPosted: %s \nBy: %s \n%s",
                            rs2.getString("PostTitle"), rs2.getDate("Created"),rs2.getString("Username"), rs2.getString("Post"));
            }
        }

    }
}
