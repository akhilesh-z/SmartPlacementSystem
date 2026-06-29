package com.controller;

import com.dao.JobDAO;
import com.model.Job;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editJob")
public class EditJobServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id =
        Integer.parseInt(request.getParameter("id"));

        JobDAO dao = new JobDAO();

        Job job = dao.getJobById(id);

        request.setAttribute("job", job);

        RequestDispatcher rd =
        request.getRequestDispatcher("editJob.jsp");

        rd.forward(request, response);

    }

}