<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.ArrayList" %>
    <%@ page import = "com.vaccination.model.Vaccination" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN HOME PAGE</title>
</head>
<body>
	<div align="center">
		<h1>SELECT ADD OR DISPLAY</h1>
		
		<form action="addvaccination">
			<button name="add">ADD</button>
			<br/><br/><br/>
		</form>
		<form action="displayvaccination">
			<button name="display">DISPLAY</button>
		</form>
		
		<form action="dis", method ="post">
		<h1>DISPLAY DOSE DEATILS</h1>
		
		<table border ="1">
			<thead>
				<tr>
					<th> CVCNO</th>
					<th> SUPERVISOR</th>
					<th> VACCINECENTER</th>
					<th> VACCINENAME</th>
					<th> DOSE</th>
					<th>NAMEPERSON</th>
					<th>MOBILE</th>
					<th>WORKINGHOUR</th>
					<th> Action</th>
					
				</tr>
			</thead>
			<tbody>
			<%ArrayList<Vaccination> vac = (ArrayList<Vaccination>)request.getAttribute("vaccinations"); 
				if (vac != null) {
				for(Vaccination v :vac)
				{
				%>
					<tr>
						<td><%=v.getCvcno() %></td>
						<td><%=v.getSupervisor() %></td>
						<td><%=v.getVaccinecenter() %></td>
						<td><%=v.getVaccinename() %></td>
						<td><%=v.getDose() %></td>
						<td><%=v.getNamePerson() %></td>
						<td><%=v.getMobile() %></td>
						<td><%=v.getWorkinghour() %></td>
						<td>
							<a href="<%=request.getContextPath() %>/delete?cvcno=<%=v.getCvcno() %>">Delete</a>
						</td>
					</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
		
		</form>
	
	</div>
</body>
</html>