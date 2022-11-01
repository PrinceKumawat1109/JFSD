<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Management</title>
</head>
<body onload="loadCourses()">
	<h3>Course Management</h3>
	<p>Select Course: <select id="course" onchange="loadTopics()" ></select></p>
	<div id="display" style="width:100%"></div>
</body>
<script type="text/javascript">
	function loadCourses()
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/callcourseapi";
		xhtml.open("GET", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		xhtml.send();
		var course = document.getElementById("course");
	
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var data = JSON.parse(this.responseText);
				for(var x in data)
				{
					var option = document.createElement("option");
					option.value = data[x].cid;
					option.text = data[x].cname;
					course.add(option);
				}
			}
		};
	}
	
	function loadTopics()
	{
		var xhtml = new XMLHttpRequest();
		var course = document.getElementById("course");
		var url = "http://localhost:8080/api/calltopicsapi/" + course.options[course.selectedIndex].value;
		xhtml.open("GET", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		xhtml.send();
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var data = JSON.parse(this.responseText);
				var table = "<table border=1>";
				table += "<tr> <th>ID</th> <th>TOPICS</th> </tr>";
				for(var x in data)
				{
					table += "<tr> <td>" + data[x].tid + "</td> <td>"+ data[x].tname +"</td> </tr>";
				}
				table += "</table>";
				var display = document.getElementById("display");
				display.innerHTML = table;
			}
		};
	}
</script>
</html>