package com.controller;

import java.io.IOException;

import com.dao.UserDAO;
import com.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Student student = new Student();

        student.setStudentId(
                Integer.parseInt(request.getParameter("studentId")));

        student.setName(request.getParameter("name"));

        student.setEmail(request.getParameter("email"));

        student.setBranch(request.getParameter("branch"));

        student.setCgpa(
                Double.parseDouble(request.getParameter("cgpa")));

        student.setSkills(request.getParameter("skills"));

        UserDAO dao = new UserDAO();

        if (dao.updateStudent(student)) {

            response.sendRedirect("profile?success=1");

        } else {

            response.sendRedirect("profile?success=0");

        }

    }

}