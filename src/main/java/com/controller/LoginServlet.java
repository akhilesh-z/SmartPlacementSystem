package com.controller;

import com.dao.LoginDAO;
import com.model.Student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        LoginDAO dao = new LoginDAO();

        Student student =
                dao.login(email, password);

        if(student != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "student", student);

            response.sendRedirect(
                    "studentdashboard.jsp");

        } else {

            response.sendRedirect(
                    "login.jsp?error=true");
        }
    }
}