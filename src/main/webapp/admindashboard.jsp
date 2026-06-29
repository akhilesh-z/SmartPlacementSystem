<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.model.Admin" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
body{
font-family:Times;
background:#f4f4f4;
}

.container{
width:600px;
margin:50px auto;
background:white;
padding:30px;
border-radius:10px;
box-shadow:0 0 10px gray;
text-align:center;
}

a{

width: 60%;
display:block;
padding:15px;
margin:15px;
background:#007BFF;
color:white;
text-decoration:none;
border-radius:5px;
font-size:18px;
}

a:hover{
background:#0056b3;
}

.center{
    text-align:center;
}

.btn{
    display:inline-block;
    padding:10px 20px;
    background:#007BFF;
    color:white;
    text-decoration:none;
    border-radius:5px;
}

button{
border-radius:5px;
font-size:15px;
padding:5px;
margin: 5px;
border: 1px solid #ccc;
cursor:pointer;
}
button:hover{
font-size:18px;
}
</style>

</head>

<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

Admin ad = (Admin) session.getAttribute("admin");

if (ad == null) {
    response.sendRedirect("adminlogin.jsp");
    return;
}
%>

<div class="container">

<h1>Admin Dashboard</h1>

<div class="center">

<a href="<%=request.getContextPath()%>/students" class="btn">Manage Students</a>

<a href="managecompanies.jsp" class="btn">Manage Companies</a>

<a href="managejobs.jsp" class="btn">Manage Jobs</a>

<a href="viewapplication.jsp" class="btn">Applications</a>

</div>

<form action="adminlogout" method="post" >

<button type="submit">Logout</button>

</form>

</div>

</body>
</html>