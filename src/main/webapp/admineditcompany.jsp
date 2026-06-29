<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.model.Admin" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<form action="admineditcompany?id=<%=request.getParameter("id")%>" method="post">


Enter New Name Of The Company <input type="text" name="cname"><br>
<br>

Enter New Email <input type="email" name="cemail"><br>
<br>
<input type="submit" value="Update">

</form>

</body>
</html>