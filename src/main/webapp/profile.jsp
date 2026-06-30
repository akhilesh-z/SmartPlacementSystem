<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.model.Student"%>

<%
Student student = (Student)request.getAttribute("student");
%>

<!DOCTYPE html>
<html>

<head>

<title>Student Profile</title>

<style>
.container{
width:400px;
margin:50px auto;
background:white;
padding:30px;
border-radius:10px;
box-shadow:0 0 10px gray;
text-align:center;
}
body{
font-family:times;
background:#f4f4f4;
}

table{
border-radius:20px;
margin:auto;
margin-top:50px;

}
input{
margin: 5px auto;
padding: 10px;
border: 1px solid #ccc;
border-radius: 8px; 
}
td{

border-radius:10px;
box-shadow:0 0 5px gray;
padding:15px;

}
a{
text-align: center;
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

<h2 align="center">Student Profile</h2>

<%

String success=request.getParameter("success");

if("1".equals(success)){
%>

<p align="center" style="color:green;">
Profile Updated Successfully
</p>

<%
}
%>

<form action="updateProfile" method="post">

<table border="1">

<tr>

<td>ID</td>

<td>

<input type="hidden"
name="studentId"
value="<%=student.getStudentId()%>">

<%=student.getStudentId()%>

</td>

</tr>

<tr>

<td>Name</td>

<td>

<input type="text"
name="name"
value="<%=student.getName()%>">

</td>

</tr>

<tr>

<td>Email</td>

<td>

<input type="email"
name="email"
value="<%=student.getEmail()%>">

</td>

</tr>

<tr>

<td>Branch</td>

<td>

<input type="text"
name="branch"
value="<%=student.getBranch()%>">

</td>

</tr>

<tr>

<td>CGPA</td>

<td>

<input type="number"
step="0.01"
name="cgpa"
value="<%=student.getCgpa()%>">

</td>

</tr>

<tr>

<td>Skills</td>

<td>

<textarea
name="skills"
rows="4"
cols="30"><%=student.getSkills()%></textarea>

</td>

</tr>

<tr>

<td colspan="2" align="center">

<button type="submit">
        Update Profile
    </button>

</td>

</tr>

</table>
<div class="container">
<%

if(student.getResume()!=null){

%>

Current Resume
<a href="<%=student.getResume()%>"
   target="_blank">
    View Resume
</a>

<%

}

%>
</form>
<hr>

<h3>Upload Resume</h3>

<form action="uploadResume"
      method="post"
      enctype="multipart/form-data">

<input
type="file"
name="resume"
accept=".pdf,.doc,.docx"
required>

<br><br>

<button
type="submit"> Upload Resume</button>

</form>

</div>

</body>

</html>