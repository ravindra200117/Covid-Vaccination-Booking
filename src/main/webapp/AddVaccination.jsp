<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD VACCINATION CENTER</title>
</head>
<body>
		
		<div align="center">
			<form action="addvc" , method="post">
				<h1 style ="color:red">ADD VACCINATION CENTER</h1>
				<label>CVCNO : </label>
				<input type = "number" name="tbCvcno" required/>
				<br/>
				<br/>
				<label>SUPERVISOR : </label>
				<input type = "text" name="tbSupervisor" required/>
				<br/>
				<br/>
				<label>VACCINECENTER : </label>
				<input type = "text" name="tbVaccinecenter" required/>
				<br/>
				<br/>
				<label>VACCINENAME : </label>
				<input type = "text" name="tbvaccinename" required/>
				<br/>
				<br/>
				<label>DOSE : </label>
				<input type = "text" name="tbDose" required/>
				<br/>
				<br/>
				<label>NAMEPERSON : </label>
				<input type = "text" name="tbNameperson" required/>
				<br/>
				<br/>
				<label>MOBILE : </label>
				<input type = "number" name="tbMobile" required/>
				<br/>
				<br/>
				<label>WORKINGHOUR : </label>
				<input type = "datetime" name="tbDatetime" required/>
				<br/>
				<br/>
				
				<button style="width : 80px; color: blue">ADD</button>
				<br/>
				<br/>
				
			</form>
			
		</div>
		
</body>
</html>