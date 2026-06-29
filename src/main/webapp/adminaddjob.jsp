<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.model.Admin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f4f7fc;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.container{
    width:450px;
    background:#fff;
    padding:30px;
    border-radius:10px;
    box-shadow:0 5px 15px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    margin-bottom:25px;
    color:#007BFF;
}

label{
    display:block;
    margin-bottom:8px;
    font-weight:bold;
    color:#333;
}

input, textarea{
    width:100%;
    padding:10px;
    margin-bottom:20px;
    border:1px solid #ccc;
    border-radius:5px;
    font-size:15px;
}

textarea{
    resize:none;
    height:100px;
}

button{
    width:100%;
    padding:12px;
    border:none;
    background:#007BFF;
    color:white;
    font-size:16px;
    border-radius:5px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#0056b3;
}

.back{
    display:block;
    text-align:center;
    margin-top:20px;
    text-decoration:none;
    color:#007BFF;
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
<div class="container">
<form action="adminaddjob" method="post">


Company ID

<input type="number" step="1" name="company_id" required>

<br><br>

Job Title

<input type="text"
name="title" required="required">

<br><br>

Description

<textarea
name="description" required>
</textarea>

<br><br>

Minimum CGPA

<input type="number"
step="0.01"
name="cgpa" required>

<br><br>

Salary

<input type="number"
name="salary" required>

<br><br>

<button>

Post Job

</button>

</form>
</div>	


</body>
</html>