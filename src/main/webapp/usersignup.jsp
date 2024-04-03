<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER SIGN UP PAGE</title>
</head>
<body>
		<div align ="center">
			<form action="sign" method="post">
				<h1 style ="color:red">USER SIGNUP PAGE</h1>
				<label>NAME : </label>
				<input type = "text" name="tbName" required />
				<br/>
				<br/>
				<label>EMAIL : </label>
				<input type = "email" name="tbEmail" required/>
				<br/>
				<br/>
				<label>PASSWORD : </label>
				<input type = "password" name="tbPassword" required/>
				<br/>
				<br/>
				<label>MOBILE NO : </label>
				<input type = "number" name="tbMob" required/>
				<br/>
				<br/>
				<label>AADHAR NO : </label>
				<input type = "number" name="tbAadhar" required/>
				<br/>
				<br/>
				
				<button>SAVE</button>
				
			</form>
		</div>
</body>
</html>