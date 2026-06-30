package com.controller;

import java.io.IOException;

import com.dao.DashboardDAO;
import com.model.Dashboard;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        DashboardDAO dao = new DashboardDAO();

        Dashboard dashboard = dao.getStatistics();

        request.setAttribute("dashboard", dashboard);

        RequestDispatcher rd =
                request.getRequestDispatcher("index.jsp");

        rd.forward(request,response);

    }

}