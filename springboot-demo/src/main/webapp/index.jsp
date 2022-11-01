<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring JDBC</title>
</head>
<body>
	<h3>Student Details</h3>
	<p>Student ID: <input type="text" id="t1" /></p>
	<p>Student Name: <input type="text" id="t2" /></p>
	<p>
		<button onclick="save()" >Insert</button>
		<button onclick="read()">Read</button>
		<button onclick="update()">Update</button>
		<button onclick="del()">Delete</button>
	</p>
	<label id="lbl"></label>
	<div style="width:100%" id="display" ></div>
</body>
<script type="text/javascript">
	function save()
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/students";
		xhtml.open("POST", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		var t1 = document.getElementById("t1");
		var t2 = document.getElementById("t2");
		var lbl = document.getElementById("lbl");
		
		xhtml.send(JSON.stringify({
			id : t1.value,
			name : t2.value
		}));
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
				lbl.innerText = this.responseText;
		};
	}
	
	function read()
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/students";
		xhtml.open("GET", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		xhtml.send();
		
		var display = document.getElementById("display");
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var table = "<table border='1'>";
				table += "<tr> <th>Student ID</th> <th>Student Name</th> </tr>";
				var data = JSON.parse(this.responseText);
				for(var x in data)
				{
					table += "<tr> <td>"+ data[x].id +"</td> <td>"+ data[x].name +"</td> </tr>";
				}
				display.innerHTML = table;
			}
		};
		
	}
	function update()
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/updatestudents";
		xhtml.open("PUT", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		var t1 = document.getElementById("t1");
		var t2 = document.getElementById("t2");
		var lbl = document.getElementById("lbl");
		
		xhtml.send(JSON.stringify({
			id : t1.value,
			name : t2.value
		}));
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
				lbl.innerText = this.responseText;
		};
	}
	function del()
	{
		var xhtml = new XMLHttpRequest();

		var t1 = document.getElementById("t1");
		var url = "http://localhost:8080/api/students/"+t1.value;
		xhtml.open("DELETE", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		xhtml.send();
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
				lbl.innerText = this.responseText;
		};
	}
</script>
</html>