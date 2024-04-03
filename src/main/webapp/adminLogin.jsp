<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN LOGIN PAGE</title>
</head>
<body>
	<div align="center">
		<form action="adminLogin" method ="post">
		
			<h1 style ="color:red">ADMIN LOGIN PAGE</h1>
			<label>Eamil : </label>
			<input type = "email" name="tbEmail" required/>
			<br/>
			<br/>
			<label>Password : </label>
			<input type ="password" name= "tbPassword" required/>
			<br/>
			<br/>
			<button name="userlogin">LOGIN</button>
			<br/>
			<br/>
			
		</form>
	</div>
</body>
</html>