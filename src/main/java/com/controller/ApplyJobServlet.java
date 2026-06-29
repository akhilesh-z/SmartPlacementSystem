package com.controller;

import com.dao.ApplicationDAO;
import com.model.Application;
import com.model.Student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/applyjob")
public class ApplyJobServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Student student =
                (Student) session.getAttribute("student");

        int jobId =
                Integer.parseInt(request.getParameter("jobId"));

        Application app = new Application();

        app.setStudentId(student.getStudentId());
        app.setJobId(jobId);

        ApplicationDAO dao = new ApplicationDAO();

        boolean success = dao.applyJob(app);

        if (success) {

            response.sendRedirect("jobs?msg=applied");

        } else {

            response.sendRedirect("jobs?msg=alreadyApplied");

        }

    }

}