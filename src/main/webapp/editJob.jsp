<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<%@page import="com.model.Job"%>

<%
Job job = (Job)request.getAttribute("job");
%>
<div class="container">
<h2 style="text-align: center;margin:10px;">Edit Job</h2>

<form action="updateJob" method="post">

<input type="hidden"
name="jobId"
value="<%=job.getJobId()%>" required>

Title

<input type="text"
name="title"
value="<%=job.getTitle()%>" required>

<br><br>

Description

<textarea
name="description" required><%=job.getDescription()%></textarea>

<br><br>

Minimum CGPA

<input type="number"
step="0.01"
name="cgpa"
value="<%=job.getMinCgpa()%>" required>

<br><br>

Salary

<input type="number"
name="salary"
value="<%=job.getSalary()%>" required>

<br><br>

<button type="submit">Update Job</button>


</form>
</div>

</body>
</html>