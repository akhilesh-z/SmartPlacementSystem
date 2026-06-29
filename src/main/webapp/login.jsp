<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

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

</head>

<body>

<div class="container">

<h2>Student Login</h2>
<div class="oneform">
<form action="login" method="post">

    Email :
    <input type="email"
           name="email" placeholder="abc@gmail.com">

    <br><br>

    Password :
    <input type="password"
           name="password">

    <br><br>

    <button type="submit">
        Login
    </button>
    

</form>

</div>
<br>

<form action="register.jsp">
! New User. Register Here !
<button type="submit">
        Register
    </button>
</form>

</div>
</body>
</html>