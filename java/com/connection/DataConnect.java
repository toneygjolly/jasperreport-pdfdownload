package com.connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
    private static Connection con;

    // Private constructor to prevent instantiation from outside
    private DataConnect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teachemployee", "root", "mysql");
            System.out.println("Connection established");
        } catch (Exception ex) {
            // Print the error message if connection fails
            System.err.println("Failed to establish connection: " + ex.getMessage());
        }
    }

    // Method to retrieve the database connection
    public static Connection getConnection() {
        // If connection is not initialized or closed, create a new one
        if (con == null) {
            new DataConnect();
        }
        return con;
    }

    // Main method to test the connection
    public static void main(String[] args) {
        // Attempt to establish a connection
        Connection connection = DataConnect.getConnection();
        if (connection != null) {
            System.out.println("Connection established");
            // You can perform database operations using the 'connection' object here
        } else {
            System.out.println("Failed to establish connection");
        }
    }
}
