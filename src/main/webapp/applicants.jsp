<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%@ page import="java.util.*" %>
<%@ page import="com.model.Applicant,com.model.Company" %>


    
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
width:800px;
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

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

Company cmp = (Company) session.getAttribute("company");

if (cmp == null) {
    response.sendRedirect("companylogin.jsp");
    return;
}
%>


<h2 style="font-size: xx-large;">Applicants</h2>

<div class="container">

<table border="1">

<tr>

<th>Name</th>
<th>Email</th>
<th>Branch</th>
<th>CGPA</th>
<th>Resume</th>
<th>Status</th>
<th>Action</th>

</tr>

<%

List<Applicant> list= (List<Applicant>)request.getAttribute("list");

for(Applicant a:list){

%>

<tr>

<td><%=a.getName()%></td>

<td><%=a.getEmail()%></td>

<td><%=a.getBranch()%></td>

<td><%=a.getCgpa()%></td>

<td><%=a.getStatus()%></td>

<td>
<%=a.getResume()%>
<a href="downloadResume?file=<%=a.getResume()%>" target="_blank">
View Resume
</a>

</td>

<td>

<a href="<%=request.getContextPath()%>/selectStudent?applicationId=<%=a.getApplicationId()%>">

Select

</a>

|

<a href="<%=request.getContextPath()%>/rejectStudent?applicationId=<%=a.getApplicationId()%>">

Reject

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