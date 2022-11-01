<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Samyak Participants</title>
</head>
<body onload="loadEvents()">
	<h3>SAMYAK 2022 - Participants Details</h3>
	<p>Select Event: <select id="events" onchange="readParticipants()" style="height:24px"><option>Select One</option></select> </p>
	<div id="display" style="width:100%"></div>
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
	function readParticipants() 
	{
		var xhtml = new XMLHttpRequest();
		var E = document.getElementById("events");
		var url = "http://localhost:8080/api/participants/" + E.options[E.selectedIndex].value;
		xhtml.open("GET", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		xhtml.send();

		var display = document.getElementById("display");

		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var data = JSON.parse(this.responseText);
				var table = "<table border=1>";
				table += "<tr> <th>PID</th> <th>Participants Name</th> <th>Email ID</th> <th>Ph.No.</th> </tr>";
				for(var x in data)
				{
					table += "<tr> <td>"+ data[x].id +"</td> <td>"+ data[x].name +"</td> <td>"+ data[x].emailid +"</td> <td>"+ data[x].phno +"</td>  </tr>";
				}
				table += "</table>";
				display.innerHTML = table;
			}
		};
	}
</script>
</html>