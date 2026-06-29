package com.dao;

import com.model.Student;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean registerStudent(Student s) {

        boolean status = false;

        try {

            Connection con =
                DBConnection.getConnection();

            String sql =
            "INSERT INTO students(name,email,password,branch,cgpa,skills) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1,s.getName());
            ps.setString(2,s.getEmail());
            ps.setString(3,s.getPassword());
            ps.setString(4,s.getBranch());
            ps.setDouble(5,s.getCgpa());
            ps.setString(6,s.getSkills());

            status = ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public List<Student> getAllStudents(){

        List<Student> list=new ArrayList<>();

        try{

            Connection con=DBConnection.getConnection();

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery(

            "SELECT * FROM students");

            while(rs.next()){

                Student s=new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setBranch(rs.getString("branch"));
                s.setCgpa(rs.getDouble("cgpa"));

                list.add(s);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }
    
    public boolean deleteStudent(int id){

        boolean status=false;

        try{

            Connection con=DBConnection.getConnection();
            
            PreparedStatement ps1=con.prepareStatement("DELETE FROM applications WHERE student_id=?");
            
            ps1.setInt(1, id);
            boolean sts=ps1.executeUpdate() > 0;
            

            PreparedStatement ps=con.prepareStatement(

            "DELETE FROM students WHERE student_id=?");

            ps.setInt(1,id);

            status=ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return status;

    }
    
    public boolean updateStudent(Student student) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE students SET name=?,email=?,branch=?,cgpa=?,skills=? WHERE student_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getBranch());
            ps.setDouble(4, student.getCgpa());
            ps.setString(5, student.getSkills());
            ps.setInt(6, student.getStudentId());

            status = ps.executeUpdate() > 0;

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public Student getStudentById(int studentId) {

        Student student = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students WHERE student_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setBranch(rs.getString("branch"));
                student.setCgpa(rs.getDouble("cgpa"));
                student.setSkills(rs.getString("skills"));
                student.setResume(rs.getString("resume"));

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }
    public boolean updateResume(int studentId,String fileName){

        boolean status=false;

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(

            "UPDATE students SET resume=? WHERE student_id=?");

            ps.setString(1,fileName);

            ps.setInt(2,studentId);

            status=ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return status;

    }
    	
   
}