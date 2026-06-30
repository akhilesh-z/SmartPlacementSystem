package com.util;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(
                "org.postgresql.Driver");
            String url = System.getenv("DB_URL");
            String username = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            // Fallback for local development
            if (url == null || url.isBlank()) {
                url = "jdbc:postgresql://localhost:5432/placement_db";
                username = "postgres";
                password = "root";
            }
            con = DriverManager.getConnection(
                url, username, password);

        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return con;
    }
}