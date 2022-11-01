<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Data</title>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="com.model.Student" %>
	<% @SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) request.getAttribute("slist"); %>
		
		<table border="1">
			<tr>
				<th>Student ID</th>
				<th>Student Name</th>
			</tr>
			<% for(Student S:list){ %>
				<tr>
					<td> <%= S.getId() %> </td>
					<td> <%= S.getName() %> </td>
				</tr>
			<%} %>
		</table>
	
</body>
</html>