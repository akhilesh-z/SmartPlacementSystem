package com.controller;

import com.dao.JobDAO;
import com.model.Job;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/updateJob")
public class UpdateJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Job job = new Job();

        job.setJobId(
        Integer.parseInt(request.getParameter("jobId")));

        job.setTitle(request.getParameter("title"));

        job.setDescription(request.getParameter("description"));

        job.setMinCgpa(
        Double.parseDouble(request.getParameter("cgpa")));

        job.setSalary(
        Double.parseDouble(request.getParameter("salary")));

        JobDAO dao = new JobDAO();

        dao.updateJob(job);

        response.sendRedirect("managejobs.jsp");

    }

}