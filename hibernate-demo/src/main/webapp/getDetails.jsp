<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Data</title>
</head>
<body>
	<h3>Student Details</h3>
	<%@ page import="java.util.*" %>
	<%@ page import="com.model.*" %>
	<% @SuppressWarnings("unchecked") 
	List<Student> list = (List<Student>) request.getAttribute("slist"); %>
	<table border=1>
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
		</tr>
		<%for(Student S:list){ %>
			<tr>
				<td><%= S.getId() %></td>
				<td><%= S.getName() %></td>
			</tr>
		<%} %>
	</table>
</body>
</html>