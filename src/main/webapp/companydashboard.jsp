<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.model.Company" %>
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
.logout{

padding:15px;


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

Company cmp = (Company) session.getAttribute("company");

if (cmp == null) {
    response.sendRedirect("companylogin.jsp");
    return;
}
%>



<div class="container">
<h2>Company Dashboard</h2>


<div class="center">
<a href="addjob.jsp"  class="btn">Post New Job</a>
</div>

<br><br>

<div class="center">

<a href="<%=request.getContextPath()%>/viewApplicants" class="btn">

View Applicants

</a>
</div>

<br><br>

<form action="logout" method="post">
	
	<button type="submit">
        Logout
    </button>
	
</form>
</div>




</body>
</html>