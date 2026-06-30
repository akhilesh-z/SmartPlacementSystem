package com.util;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String url = "jdbc:postgresql://localhost:5432/placement_db";
	private static final String username = "postgres";
	private static final String password = "root";
    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(
                "org.postgresql.Driver");

            con = DriverManager.getConnection(
                url, username, password);

        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return con;
    }
}