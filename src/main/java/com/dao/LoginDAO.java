package com.dao;

import java.sql.*;
import com.model.Student;
import com.util.DBConnection;

public class LoginDAO {

    public Student login(String email, String password) {

        Student student = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
              "SELECT * FROM students WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                student = new Student();

                student.setStudentId(
                        rs.getInt("student_id"));

                student.setName(
                        rs.getString("name"));

                student.setEmail(
                        rs.getString("email"));

                student.setCgpa(
                        rs.getDouble("cgpa"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return student;
    }
}