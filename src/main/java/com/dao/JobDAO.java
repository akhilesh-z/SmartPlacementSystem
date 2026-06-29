package com.dao;

import java.sql.*;
import java.util.*;

import com.model.Job;
import com.util.DBConnection;

public class JobDAO {

    public List<Job> getEligibleJobs(
            double cgpa) {

        List<Job> jobs =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
             "SELECT * FROM jobs WHERE min_cgpa <= ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setDouble(1, cgpa);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Job job = new Job();

                job.setJobId(
                    rs.getInt("job_id"));

                job.setTitle(
                    rs.getString("title"));

                job.setDescription(
                    rs.getString("description"));

                job.setSalary(
                    rs.getDouble("salary"));

                jobs.add(job);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return jobs;
    }
    public boolean addJob(Job job){

	    boolean status=false;

	    try{

	        Connection con=DBConnection.getConnection();

	        PreparedStatement ps=con.prepareStatement(

	        "INSERT INTO jobs(company_id,title,description,min_cgpa,salary) VALUES(?,?,?,?,?)");

	        ps.setInt(1,job.getCompanyId());
	        ps.setString(2,job.getTitle());
	        ps.setString(3,job.getDescription());
	        ps.setDouble(4,job.getMinCgpa());
	        ps.setDouble(5,job.getSalary());

	        status=ps.executeUpdate()>0;

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return status;
	}
    
    public List<Job> getAllJobs(){
    	List<Job> list=new ArrayList<>();
    	try {
    		Connection con=DBConnection.getConnection();
    		
    		Statement st=con.createStatement();
    		
    		ResultSet rs=st.executeQuery("select * from jobs");
    		
    		while(rs.next()) {
    			Job job=new Job();
    			
    			job.setJobId(rs.getInt("job_id"));
    			job.setCompanyId(rs.getInt("company_id"));
    			job.setTitle(rs.getString("title"));
    			job.setDescription(rs.getString("description"));
    			job.setMinCgpa(rs.getDouble("min_cgpa"));
    			job.setSalary(rs.getDouble("salary"));
    			
    			list.add(job);
    			
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    public boolean AdminAddJob(int id,String title,String description, Double cgpa, int salary ) {
    	boolean status=false;
    	
    	try {
    		Connection con=DBConnection.getConnection();
    		
    		String sql="insert into jobs(company_id,title,description,min_cgpa,salary) values(?,?,?,?,?)";
    		
    		PreparedStatement ps=con.prepareStatement(sql);
    		
    		ps.setInt(1, id);;
    		ps.setString(2, title);;
    		ps.setString(3, description);
    		ps.setDouble(4, cgpa);
    		ps.setInt(5,salary);
    		
    		status = ps.executeUpdate()>0;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
}