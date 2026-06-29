package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.JobDAO;

/**
 * Servlet implementation class AdminAddJobServlet
 */
@WebServlet("/adminaddjob")
public class AdminAddJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddJobServlet() {
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

		int id=Integer.parseInt(request.getParameter("company_id"));
		
		String title=request.getParameter("title");
		String description = request.getParameter("description");
		
		Double cgpa=Double.parseDouble(request.getParameter("cgpa"));
		
		int salary=Integer.parseInt(request.getParameter("salary"));
		
		JobDAO dao=new JobDAO();
		dao.AdminAddJob(id, title, description, cgpa, salary);
		
		response.sendRedirect("managejobs.jsp");
		
	}

}
