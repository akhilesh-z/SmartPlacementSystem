<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
font-family:times;
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
h2{
font-size: xx-large;
}

.oneform{
width: 200px;
margin: 50px auto;
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
}
</style>
</head>
<body>
<div class="container">

<h2>Company Register</h2>
	<form action="companyregister" method="post">
	
		<input type="text"
name="companyname"
placeholder="Name" required><br>

<input type="email"
name="cemail"
placeholder="Email" required><br>

<input type="password"
name="cpassword"
placeholder="Password" required><br>




<input type="number"
step="0.01"
name="cgpa"
placeholder="CGPA"><br>

<button type="submit">
Register
</button>
		
	
	</form>


</div>
</body>
</html>