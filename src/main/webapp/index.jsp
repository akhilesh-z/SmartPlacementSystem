<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.model.Dashboard"%>

<%
Dashboard d=(Dashboard)request.getAttribute("dashboard");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Smart Placement Management System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<style>

body{

background:#f4f7fc;

}

.hero{

background:#0d6efd;

color:white;

padding:80px;

text-align:center;

}

.card{

transition:.3s;

}

.card:hover{

transform:translateY(-5px);

box-shadow:0 8px 20px rgba(0,0,0,.2);

}

footer{

background:#212529;

color:white;

padding:20px;

margin-top:50px;

}

</style>

</head>

<body>

<!-- Navbar -->

<nav class="navbar navbar-dark bg-dark">

<div class="container">

<a class="navbar-brand" href="#">

Smart Placement Management System

</a>

</div>

</nav>

<!-- Hero -->

<div class="hero">

<h1>Welcome</h1>

<h3>Smart Placement Management System</h3>

<p>

Campus Recruitment Automation Portal

</p>

</div>

<div class="container mt-5">

<div class="row">

<div class="col-md-4">

<div class="card">

<div class="card-body text-center">

<h3>Student</h3>

<p>

Apply for Jobs

</p>

<a href="login.jsp"

class="btn btn-primary">

Student Login

</a>

</div>

</div>

</div>

<div class="col-md-4">

<div class="card">

<div class="card-body text-center">

<h3>Company</h3>

<p>

Recruit Students

</p>

<a href="companylogin.jsp"

class="btn btn-success">

Company Login

</a>

</div>

</div>

</div>

<div class="col-md-4">

<div class="card">

<div class="card-body text-center">

<h3>Administrator</h3>

<p>

Manage Portal

</p>

<a href="adminlogin.jsp"

class="btn btn-danger">

Admin Login

</a>

</div>

</div>

</div>

</div>

</div>

<!-- About -->

<div class="container mt-5">

<h2 align="center">

About Project

</h2>

<p align="justify">

The Smart Placement Management System is a web-based application
developed using Java, JSP, Servlets, JDBC, and PostgreSQL.
It simplifies campus recruitment by allowing students to apply for
jobs, companies to recruit candidates, and administrators to manage
placement activities through a centralized portal.

</p>

</div>

<!-- Statistics -->

<div class="container mt-5">

<div class="row text-center">

<div class="col-md-3">

<div class="card bg-primary text-white">

<div class="card-body">

<h2><%=d.getTotalStudents()%></h2>
Students

</div>

</div>

</div>

<div class="col-md-3">

<div class="card bg-success text-white">

<div class="card-body">

<h2><%=d.getTotalCompanies() %></h2>

Companies

</div>

</div>

</div>

<div class="col-md-3">

<div class="card bg-warning">

<div class="card-body">

<h2><%=d.getTotalJobs() %></h2>

Jobs

</div>

</div>

</div>

<div class="col-md-3">

<div class="card bg-danger text-white">

<div class="card-body">

<h2><%=String.format("%.2f",d.getPlacementPercentage())%>%</h2>
Placement Rate

</div>

</div>

</div>

</div>

</div>

<footer class="text-center">

© 2026 Smart Placement Management System

</footer>

</body>

</html>