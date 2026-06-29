package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.JobDAO;
import com.model.Company;
import com.model.Job;

/**
 * Servlet implementation class AddJobServlet
 */
@WebServlet("/addjobservlet")
public class AddJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJobServlet() {
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
	 protected void doPost(HttpServletRequest request,
	            HttpServletResponse response)
			throws ServletException, IOException {
			
			HttpSession session=request.getSession();
			
			response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");
						
			Company company=(Company)session.getAttribute("company");
			
			Job job=new Job();
			
			job.setCompanyId(company.getCompanyId());
			job.setTitle(request.getParameter("title"));
			job.setDescription(request.getParameter("description"));
			job.setMinCgpa(Double.parseDouble(request.getParameter("cgpa")));
			job.setSalary(Double.parseDouble(request.getParameter("salary")));
			
			JobDAO dao=new JobDAO();
			
			dao.addJob(job);
			
			response.sendRedirect("companydashboard.jsp");
			
			}


}
