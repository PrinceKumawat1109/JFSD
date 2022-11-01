<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hibernate Demo</title>
</head>
<body>
	<h3>Insert using Hibernate</h3>
	<form action="AddStudent" method="get">
		<p> Student ID : <input type="text" name="t1" /> </p>
		<p> Student Name : <input type="text" name="t2" /> </p>
		<input type="submit" value="Insert" />
	</form>
	<h3>Delete using Hibernate</h3>
	<form action="DeleteStudent" method="get">
		<p> Student ID : <input type="text" name="t1" /> </p>
		<input type="submit" value="Delete" />
	</form>
	<h3>Update using Hibernate</h3>
	<form action="UpdateStudent" method="get">
		<p> Student ID : <input type="text" name="t1" /> </p>
		<p> Student Name : <input type="text" name="t2" /> </p>
		<input type="submit" value="Update" />
	</form>
	<a href="ReadStudent">getDetails</a>
</body>
</html>