package com.util;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String url =
        "jdbc:postgresql://localhost:5432/placement_db";

    private static final String user = "postgres";
    private static final String pass = "root";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(
                "org.postgresql.Driver");

            con = DriverManager.getConnection(
                url, user, pass);

        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return con;
    }
}