package com.util;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String url = System.getenv("DB_URL");
	private static final String username = System.getenv("DB_USER");
	private static final String password = System.getenv("DB_PASSWORD");
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