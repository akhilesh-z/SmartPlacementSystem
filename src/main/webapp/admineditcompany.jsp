<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.model.Admin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

<style>
body{
font-family:times;
background:#f4f4f4;
align-content: center;
text-align: center;
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
h2{
font-size: xx-large;
}

.oneform{
width: 500px;
margin: 20px auto;
padding: 20px;
border: 1px solid #ccc;
border-radius: 8px;


display:block;



background:#007BFF;
color:white;
text-decoration:none;


font-size:18px;

}
input{

margin: 5px auto;
padding: 10px;
border: 1px solid #ccc;
border-radius: 8px; 
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
cursor:pointer;
}
</style>

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
<h3 style="font-size: xx-large;">Edit Company Details</h3>
<div class="oneform">
<form action="admineditcompany?id=<%=request.getParameter("id")%>" method="post">


Enter New Name Of The Company: <input type="text" name="cname" required><br>
<br>

Enter New Email: <input type="email" name="cemail" required><br>
<br>
<button type="submit"> Update </button>

</form>
</div>
</div>
</body>
</html>