package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Company;
import com.util.DBConnection;

/**
 * Servlet implementation class CompanyLoginServlet
 */
@WebServlet("/companylogin")
public class CompanyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    Company company=null;
 
	    try{
	    	
	    	String email=request.getParameter("cemail");
	    	String password=request.getParameter("cpassword");

	        Connection con=DBConnection.getConnection();

	        PreparedStatement ps=con.prepareStatement(
	        "SELECT * FROM companies WHERE email=? AND password=?");

	        ps.setString(1,email);
	        ps.setString(2,password);

	        ResultSet rs=ps.executeQuery();

	        if(rs.next()){

	            company=new Company();

	            company.setCompanyId(rs.getInt("company_id"));
	            company.setCompanyName(rs.getString("company_name"));
	            company.setEmail(rs.getString("email"));
	            HttpSession session= request.getSession();
	            session.setAttribute("company", company);
	            response.sendRedirect("companydashboard.jsp");

	        }
	        else {
	        	response.sendRedirect("companylogin.jsp");
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    
	}

}
