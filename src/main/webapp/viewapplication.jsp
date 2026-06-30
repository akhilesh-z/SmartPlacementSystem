<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.dao.ApplicationDAO,com.model.Application,com.model.Admin"%>

<%
ApplicationDAO dao=new ApplicationDAO();
List<Application> apps=dao.getAllApplications();
%>



<html>


<head>
<style>
body{
font-family:Times;
background:#f4f4f4;
text-align:center;
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
display:block;
padding:15px;
margin:15px;
background:#007BFF;
color:white;
text-decoration:none;
border-radius:5px;
font-size:18px;
}

table{
    margin:auto;
    width:80%;
    border-collapse:collapse;
}

th,td{
    border:1px solid #ddd;
    padding:10px;
}

th{
    background:#007bff;
    color:white;
}

a:hover{
background:#0056b3;
}
.back{
    display:block;
    text-align:center;
    margin-top:20px;
    text-decoration:none;
    
    font-weight:bold;
}

.back:hover{
    text-decoration:underline;
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

<h2 style="font-size:xx-large;margin:30px; ">Applications</h2>

<div class="container">
<table border="1">

<tr>

<th>Application ID</th>

<th>Student ID</th>

<th>Job ID</th>

<th>Status</th>



</tr>

<%
for(Application a:apps){
%>

<tr>

<td><%=a.getApplicationId()%></td>

<td><%=a.getStudentId()%></td>

<td><%=a.getJobId()%></td>

<td><%=a.getStatus()%></td>



</tr>

<%
}
%>

</table>
<a href="admindashboard.jsp" class="back">← Back to Dashboard</a>
</div>
</body>

</html>