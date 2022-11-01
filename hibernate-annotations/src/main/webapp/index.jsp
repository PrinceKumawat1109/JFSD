<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.model.StudentManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hibernate Annotations</title>
</head>
<body>
	<h3>Insert using Hibernate-Annotaions</h3>
	<form action="AddStudent" method="get">
		<p>Student ID : <input type="text" name="t1" /> </p>
		<p>Student Name : <input type="text" name="t2" /> </p>
		<input type="submit" value="Insert">
	</form>
	<h3>Delete using Hibernate</h3>
	<form action="DeleteData" method="get">
		<p>Enter Student ID: <input type="text" name="t1" /> </p>
		<input type="submit" value="Delete" />
	</form>
	<h3>Update using Hibernate</h3>
	<form action="UpdateStudent" method="get">
		<p> Student ID : <input type="text" name="t1" /> </p>
		<p> Student Name : <input type="text" name="t2" /> </p>
		<input type="submit" value="Update" />
	</form>
	
	<h3> Read Using HQL-Hibernate Query Language</h3>
	<form action="ReadStudent" method="get">
	<p>Enter Student ID : <input type="text" name="t1"/></p>
	<p>
	<input type="submit" value="Read Data"/>
	</p>
	</form>
	
	<h3>Update using HQL</h3>
	<form action="updateusingHQL" method="get">
		<p> Student ID : <input type="text" name="t1" /> </p>
		<p> Student Name : <input type="text" name="t2" /> </p>
		<input type="submit" value="Update" />
	</form>
	<h3>Delete using HQL</h3>
	<form action="deleteusingHQL" method="get">
		<p> Student ID : <input type="text" name="t1" /> </p>
		<input type="submit" value="Delete" />
	</form>
	
	<h3>Table Data</h3>
  <table border="1">
  <%
  StudentManager sm = new StudentManager();
  List<Student> list = sm.read();
  %>
      <tr>
        <th>Student ID</th>
        <th>Student Name</th>
      </tr>
      <% for(Student S:list){ %>
        <tr>
          <td> <%= S.getId() %> </td>
          <td> <%= S.getName() %> </td>
          <%} %>
        </tr>
      
    </table>
</body>
</html>