<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inheritance data insertion(Type-1)</title>
</head>
<body>
<form action="AddEmployee" method="get">
<h3>Employee parent class</h3>
<h2>Id set to auto generation</h2>
<p> Employee name: <input name="t1" /></p>
<input type="submit" value="save employee">
</form>



<form action="AddRegularEmployee" method="get">
<h3>Regular employee</h3>
<h2>Id set to auto generation</h2>
<p> Employee name: <input name="t1" /></p>
<p> Salary: <input name="t2" /></p>
<p> Bonus: <input name="t3" /></p>
<input type="submit" value="save Remployee" />
</form>


<form action="AddContractEmployee" method="get">
<h3>Contract employee</h3>
<h2>Id set to auto generation</h2>
<p> Employee name: <input name="t1" /></p>
<p> pay per hour: <input name="t2" /></p>
<p> Contract duration: <input name="t3" /></p>
<input type="submit" value="save Cemployee" />
</form>
</body>
</html>