package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dao.JobDAO;
import com.model.Job;
import com.model.Student;

@WebServlet("/jobs")
public class JobServlet
extends HttpServlet {

 protected void doGet(
 HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {

    HttpSession session =
         request.getSession();

    Student student =
      (Student)session.getAttribute(
       "student");

    JobDAO dao =
         new JobDAO();

    List<Job> jobs =
      dao.getEligibleJobs(
       student.getCgpa());

    request.setAttribute(
      "jobs", jobs);

    RequestDispatcher rd =
      request.getRequestDispatcher(
       "jobs.jsp");

    rd.forward(request,response);
 }
}