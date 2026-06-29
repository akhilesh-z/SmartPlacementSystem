<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post New Job</title>

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
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

if(session.getAttribute("company")==null){
    response.sendRedirect("companylogin.jsp");
    return;
}
%>

<div class="container">

<h2>Post New Job</h2>

<form action="addjobservlet" method="post">

<label>Job Title</label>
<input type="text" name="title" required>

<label>Description</label>
<textarea name="description" required></textarea>

<label>Minimum CGPA</label>
<input type="number" step="0.01" name="cgpa" required>

<label>Salary (₹)</label>
<input type="number" name="salary" required>

<button type="submit">Post Job</button>

</form>

<a href="companydashboard.jsp" class="back">← Back to Dashboard</a>

</div>

</body>
</html>