package com.controller;

import com.dao.ApplicationDAO;
import com.model.Company;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/viewApplicants")
public class ViewApplicantsServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException,IOException{

        HttpSession session=request.getSession();

        Company company=(Company)
                session.getAttribute("company");

        ApplicationDAO dao=new ApplicationDAO();

        request.setAttribute(
                "list",
                dao.getApplicants(company.getCompanyId()));

        RequestDispatcher rd=request.getRequestDispatcher(
                "applicants.jsp");

        rd.forward(request,response);

    }

}