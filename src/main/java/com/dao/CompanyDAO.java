package com.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Company;
import com.util.DBConnection;

public class CompanyDAO {

    public boolean registerCompany(Company company) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "INSERT INTO companies(company_name,email,password,min_cgpa) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.println(company.getCompanyName());
            System.out.println(company.getEmail());
            
            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getEmail());
            ps.setString(3, company.getPassword());
            ps.setDouble(4, company.getMinCgpa());

            status = ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public List<Company> getAllCompanies(){
    	
    	List<Company> list=new ArrayList<>();
    	try {

            Connection con = DBConnection.getConnection();
            
            

            Statement st = con.createStatement();

            ResultSet rs=st.executeQuery("select * from companies");
            
            while(rs.next()) {
            	
            	Company company=new Company();
            	company.setCompanyId(rs.getInt("company_id"));
            	company.setCompanyName(rs.getString("company_Name"));
            	company.setEmail(rs.getString("email"));
            	
            	list.add(company);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    	return list;

    }
    
    public boolean deleteCompany(int id) {
    	
    	boolean status=false;
    	
    	try {
    		Connection con=DBConnection.getConnection();
    		
    		PreparedStatement st0=con.prepareStatement("select * from jobs where company_id=?");
    		st0.setInt(1, id);
    		
    		ResultSet rs=st0.executeQuery();
    		
    		List<Integer> ls=new ArrayList<>();
    		
    		while(rs.next()) {
    			ls.add(rs.getInt("job_id"));
    		}
    		
    		PreparedStatement ps=con.prepareStatement("delete from applications where job_id=?");
    		for(int i:ls) {
    			ps.setInt(1, i);
    			
    			status=ps.executeUpdate()>0;
    		}
    		
    		PreparedStatement st1=con.prepareStatement("delete from jobs where company_id=?");
    		st1.setInt(1,id);
    		status=st1.executeUpdate() > 0;
    		
    		PreparedStatement st=con.prepareStatement("delete from companies where company_id=?");
    		
    		st.setInt(1, id);
    		
    		status=st.executeUpdate() > 0;
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    
    public boolean editCompany(int id, String name, String email) {
    	boolean status=false;
    	
    	try {
    		Connection con=DBConnection.getConnection();
    		
    		String sql="update companies set company_name=?,email=? where company_id=?";
    		
    				
    		
    		PreparedStatement ps=con.prepareStatement(sql);
    		
    		ps.setString(1,name);
    		ps.setString(2,email);
    		ps.setInt(3, id);
    		
    		status = ps.executeUpdate() > 0;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    
}