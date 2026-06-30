<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
a:hover{
background:#0056b3;
}
</style>
</head>
<body>



<%@page import="java.util.*"%>
<%@page import="com.model.Student,com.model.Admin"%>




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

<h2>Students</h2>

<div class="container">

<table border="1">

<tr>

<th>ID</th>

<th>Name</th>

<th>Email</th>

<th>Branch</th>

<th>CGPA</th>

<th>Delete</th>

</tr>

<%

List<Student> list=(List<Student>)request.getAttribute("students");

if(list==null){
	//out.println("No Student Data Available");
	return;
}
%>

<br>
<%

for(Student s:list){

%>

<tr>

<td><%=s.getStudentId()%></td>

<td><%=s.getName()%></td>

<td><%=s.getEmail()%></td>

<td><%=s.getBranch()%></td>

<td><%=s.getCgpa()%></td>

<td>

<a href="<%=request.getContextPath()%>/deleteStudent?id=<%=s.getStudentId()%>">

Delete

</a>

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