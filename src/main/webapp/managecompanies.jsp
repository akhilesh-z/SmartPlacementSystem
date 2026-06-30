<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.dao.CompanyDAO,com.model.Company,com.model.Admin"%>

<%
CompanyDAO dao=new CompanyDAO();
List<Company> companies=dao.getAllCompanies();
%>

<html>
<head>
<title>Manage Companies</title>
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

<h2 style="font-size:xx-large;margin:30px">Companies</h2>

<div class="container">

<a href="admincompanyregister.jsp">Add Company</a>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Action</th>

</tr>

<%
for(Company c:companies){
%>

<tr>

<td><%=c.getCompanyId()%></td>
<td><%=c.getCompanyName()%></td>
<td><%=c.getEmail()%></td>


<td>

<a href="admineditcompany.jsp?id=<%=c.getCompanyId()%>">Edit</a>

	

<a href="admindeleteCompany?id=<%=c.getCompanyId()%>">Delete</a>

</td>

</tr>

<%
}
%>

</table>
<a href="admindashboard.jsp" class="back">← Back to Dashboard</a>
</div>

</body>
</html>