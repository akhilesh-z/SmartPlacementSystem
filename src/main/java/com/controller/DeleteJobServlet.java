package com.controller;

import com.dao.JobDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deleteJob")
public class DeleteJobServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id =
        Integer.parseInt(request.getParameter("id"));

        JobDAO dao = new JobDAO();

        dao.deleteJob(id);

        response.sendRedirect("managejobs.jsp");

    }

}