<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%@ page import="java.util.*" %>
<%@ page import="com.model.Job,com.dao.JobDAO,com.model.Student" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
</style>


</head>
<body>



<h2>Eligible Jobs</h2>

<div class="container">

<table border="1">

<tr>
<th>Title</th>
<th>Description</th>
<th>Salary</th>
<th>Apply</th>
</tr>

<%
JobDAO jd=new JobDAO();
if(session.getAttribute("student")==null){
	 response.sendRedirect("login.jsp");
	 return;
}

Student st= (Student) session.getAttribute("student");

List<Job> jobs = jd.getEligibleJobs(st.getCgpa());

for(Job job : jobs){
%>

<tr>

<td><%=job.getTitle()%></td>

<td><%=job.getDescription()%></td>

<td><%=job.getSalary()%></td>

<td>

<a href="<%=request.getContextPath()%>/applyjob?jobId=<%=job.getJobId()%>">
    Apply
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