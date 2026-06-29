<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

width:50%;
display:block;
padding:15px;
margin:5px;
background:#007BFF;
color:white;
text-decoration:none;
border-radius:5px;
font-size:18px;
}

a:hover{
background:#0056b3;
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
</style>


</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

Student st = (Student) session.getAttribute("student");

if (st == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<div class="container">
<h1>Student Dashboard</h1>
<div class="center">
<a href="jobs.jsp" class="btn">
View Eligible Jobs
</a>
</div>
<br><br>
<div class="center">
<a href="profile" class="btn">My Profile</a>
</div>
<br><br>
<div class="center">
<a href="<%=request.getContextPath()%>/applications" class="btn">
Applied Jobs
</a>
</div>

<br><br>



<form action="studentlogout" method="post">
	<button type="submit">
        Logout
    </button>
	

</form>

</div>

</body>
</html>