<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">
<title>Samyak Registration</title>
</head>
<body onload="loadEvents()">
	<h3>SAMYAK 2022 - New Registration</h3>
	<table style="width:100%">
		<tr>
			<td style="width:100px">Name</td><td> <input type="text" id="t1"/> </td>
		</tr>
		<tr>
			<td>Email ID</td><td> <input type="text" id="t2"/> </td>
		</tr>
		<tr>
			<td>Mobile No</td><td> <input type="text" id="t3"/> </td>
		</tr>
		<tr>
			<td>Select Event</td><td> <select id="events" style="height:24px"><option>Select One</option></select> </td>
		</tr>
		<tr>
			<td></td><td> <button onclick="register()">Register</button> </td>
		</tr>
		<tr>
			<td></td><td> <label id="lbl"></label> </td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	
	function loadEvents() 
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/events";
		xhtml.open("GET", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		xhtml.send();
		var E = document.getElementById("events");
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var data = JSON.parse(this.responseText);
				for(var x in data)
				{
					var option = document.createElement("option");
					option.value = data[x].id;
					option.text = data[x].eventname;
					E.add(option);
				}
			}
		};
	}
	
	function register() 
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/registration";
		xhtml.open("POST", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		var t1 = document.getElementById("t1");
		var t2 = document.getElementById("t2");
		var t3 = document.getElementById("t3");
		var E = document.getElementById("events");
		
		xhtml.send(JSON.stringify({
			name : t1.value,
			emailid : t2.value,
			phno : t3.value,
			event_id : E.options[E.selectedIndex].value
		}));
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var lbl = document.getElementById("lbl");
				lbl.innerText = this.responseText;
			}
		};
	}
</script>
</html>