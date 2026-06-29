package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.UserDAO;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException,IOException{

        int id=Integer.parseInt(request.getParameter("id"));

        UserDAO dao=new UserDAO();

        dao.deleteStudent(id);

        response.sendRedirect("students.jsp");

    }

}