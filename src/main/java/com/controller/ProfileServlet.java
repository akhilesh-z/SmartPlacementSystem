package com.controller;

import java.io.IOException;

import com.dao.UserDAO;
import com.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        Student loginStudent = (Student) session.getAttribute("student");

        UserDAO dao = new UserDAO();

        Student student = dao.getStudentById(loginStudent.getStudentId());

        request.setAttribute("student", student);

        RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");

        rd.forward(request, response);

    }

}