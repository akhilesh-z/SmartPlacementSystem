package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.CompanyDAO;
import com.model.Company;

/**
 * Servlet implementation class CompanyRegisterServlet
 */
@WebServlet("/admincompanyregisterservlet")
public class AdminCompanyRegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Company company = new Company();

        company.setCompanyName(request.getParameter("companyname"));
        company.setEmail(request.getParameter("cemail"));
        company.setPassword(request.getParameter("cpassword"));
        company.setMinCgpa(Double.parseDouble(request.getParameter("cgpa")));

        System.out.println(company.getCompanyName());
        System.out.println(company.getEmail());
        CompanyDAO dao = new CompanyDAO();

        if (dao.registerCompany(company)) {
            response.sendRedirect("managecompanies.jsp");
        } else {
            response.sendRedirect("admincompanyregister.jsp");
        }
    }
}