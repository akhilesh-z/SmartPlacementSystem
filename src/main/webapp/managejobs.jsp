<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.dao.JobDAO,com.model.Job"%>

<%
JobDAO dao=new JobDAO();
List<Job> jobs=dao.getAllJobs();
%>

<head>
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

table{
    margin:auto;
    width:100%;
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


</style>


</head>

<html>
<body>

<div class="container">

<h2>Manage Jobs</h2>

<a href="adminaddjob.jsp">Add Job</a>

<table border="1">

<tr>

<th>ID</th>
<th>Title</th>
<th>Company</th>
<th>Salary</th>
<th>CGPA</th>
<th>Action</th>

</tr>

<%
for(Job j:jobs){
%>

<tr>

<td><%=j.getJobId()%></td>

<td><%=j.getTitle()%></td>

<td><%=j.getCompanyId()%></td>

<td><%=j.getSalary()%></td>

<td><%=j.getMinCgpa()%></td>

<td>

<a href="editJob?id=<%=j.getJobId()%>" class="btn btn-warning btn-sm">
    Edit
</a>

|

<a href="deleteJob?id=<%=j.getJobId()%>"
   class="btn btn-danger btn-sm"
   onclick="return confirm('Are you sure you want to delete this job?');">
    Delete
</a>


</td>

</tr>

<%
}
%>

</table>

</div>	

</body>
</html>