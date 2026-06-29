package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ApplicationDAO;
import com.model.Company;
import com.model.Student;

/**
 * Servlet implementation class ApplicationsServlet
 */
@WebServlet("/applications")
public class ApplicationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
		throws ServletException,IOException{
		
		HttpSession session=request.getSession();
		
		Student student=(Student)
		   session.getAttribute("student");
		
		ApplicationDAO dao=new ApplicationDAO();
		
		request.setAttribute(
		   "list",
		   dao.getApplications(student.getStudentId()));
		
		RequestDispatcher rd=request.getRequestDispatcher(
		   "applications.jsp");
		
		rd.forward(request,response);
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
