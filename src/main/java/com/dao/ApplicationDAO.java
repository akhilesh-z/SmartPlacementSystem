package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Applicant;
import com.model.Application;
import com.util.DBConnection;

public class ApplicationDAO {

    public boolean applyJob(Application app) {

        boolean status = false;

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement check = con.prepareStatement(
                    "SELECT * FROM applications WHERE student_id=? AND job_id=?");
        ) {

            check.setInt(1, app.getStudentId());
            check.setInt(2, app.getJobId());

            ResultSet rs = check.executeQuery();

            if (rs.next()) {

                return false;

            }

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO applications(student_id,job_id,status) VALUES(?,?,?)");

            ps.setInt(1, app.getStudentId());
            ps.setInt(2, app.getJobId());
            ps.setString(3, "Applied");

            status = ps.executeUpdate() > 0;

            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;

    }
    public List<Applicant> getApplicants(int companyId){

        List<Applicant> list=new ArrayList<>();

        try(

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(

            "SELECT a.application_id,a.status,"
          + "s.student_id,s.name,s.email,s.branch,s.cgpa,s.resume "
          + "FROM applications a "
          + "JOIN students s "
          + "ON a.student_id=s.student_id "
          + "JOIN jobs j "
          + "ON a.job_id=j.job_id "
          + "WHERE j.company_id=?");

        ){

            ps.setInt(1,companyId);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                Applicant a=new Applicant();

                a.setApplicationId(rs.getInt("application_id"));
                a.setStudentId(rs.getInt("student_id"));
                a.setName(rs.getString("name"));
                a.setEmail(rs.getString("email"));
                a.setBranch(rs.getString("branch"));
                a.setCgpa(rs.getDouble("cgpa"));
                a.setStatus(rs.getString("status"));
                a.setResume(rs.getString("resume"));
                System.out.println("Resume = " + rs.getString("resume"));
                list.add(a);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }
    
    public boolean updateStatus(int applicationId, String status) {

        String sql = "UPDATE applications SET status=? WHERE application_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, applicationId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<Application> getApplications(int studentId){

        List<Application> list=new ArrayList<>();

        try(

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement("select * from applications where student_id=?");

        ){

            ps.setInt(1,studentId);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                Application a=new Application();

                a.setApplicationId(rs.getInt("application_id"));
                a.setStudentId(rs.getInt("student_id"));
                a.setJobId(rs.getInt("job_id"));
                a.setStatus(rs.getString("status"));

                list.add(a);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }
    
    public List<Application> getAllApplications(){

        List<Application> list=new ArrayList<>();

        try(

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement("select * from applications ");

        ){

           

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                Application a=new Application();

                a.setApplicationId(rs.getInt("application_id"));
                a.setStudentId(rs.getInt("student_id"));
                a.setJobId(rs.getInt("job_id"));
                a.setStatus(rs.getString("status"));

                list.add(a);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }

}