<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.vaccination.model.Vaccination" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>USER HOME PAGE</title>
    <style type="text/css">
        input {
            margin-top: 40px;
            width: 400px;
            height: 35px;
        }

        .btn {
            width: 120px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
<div align="center">
    <div align="left">
        <form action="search" method="post">
            <label for="searchInput">Search Vaccination Center:</label>
            <input type="text" id="searchInput" name="searchInput" placeholder="Search vaccination center"/>
            <button type="submit" name="btnSearch">SEARCH</button>
        </form>
        <input type="submit" value="BOOK SLOT" class="btn">
    </div>
    <div align="right" style="margin-right: 50px; margin-top: 0px;">
        <form action="logout" method="post">
            <button name="log" style="width:120px;">LOGOUT</button>
        </form>
    </div>
</div>
<br><br/><br><br/>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null) { %>
    <div style="color: red;"><%= errorMessage %></div>
<% } else { %>
    <!-- Your table and data display code here -->
    <form >
<div align="center">
    <table border="1">
        <thead>
        <tr>
            <th>CVCNO</th>
            <th>SUPERVISOR</th>
            <th>VACCINECENTER</th>
            <th>VACCINENAME</th>
            <th>DOSE</th>
            <th>NAMEPERSON</th>
            <th>MOBILE</th>
            <th>WORKINGHOUR</th>
        </tr>
        </thead>
        <tbody>
        <% ArrayList<Vaccination> searchResults = (ArrayList<Vaccination>) request.getAttribute("searchs");
            if (searchResults != null) {
                for (Vaccination v : searchResults) {
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
                    </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</form>
<% } %>


</body>
</html>
