package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.UserDAO;
import com.model.Student;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	

	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response)
	            throws ServletException,IOException{

	        UserDAO dao=new UserDAO();

	        List<Student> students=dao.getAllStudents();

	        request.setAttribute("students",students);

	        RequestDispatcher rd=request.getRequestDispatcher(
	                "students.jsp");

	        rd.forward(request,response);

	    }

	

}
