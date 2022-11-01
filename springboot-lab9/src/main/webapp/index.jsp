<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File uploading and Downloading</title>
</head>
<body onload="loadfiles()">
	<h3>File Upload</h3>
	<p>Select a File <input type="file" id="myFile" name="myFile" /> </p>
	<p> <button onclick="upload()" >Click here to upload</button> </p>
	<p> <label id="status" ></label> </p>
	
	<h3>./src/main/webapp/upload</h3>
	<div id="display" style="width:100%"></div>
</body>
<script type="text/javascript">
	function upload()
	{
		var formData = new FormData();
		formData.append("myFile", document.getElementById("myFile").files[0]);
		
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/upload";
		xhtml.open("POST", url, true);
		
		var mytimer = setInterval(getStatus, 1000);
		
		xhtml.send(formData);
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				clearInterval(mytimer);
				var status = document.getElementById("status");
				status.innerText = this.responseText;
			}
		};
	}
	
	function getStatus()
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/status";
		xhtml.open("GET", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		xhtml.send();
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var data = JSON.parse(this.responseText);
				var status = document.getElementById("status");
				status.innerText = "Uploading " + data.uploadedbytes + " of " + data.filesize;
			}
		};
	}
	
	function loadfiles()
	{
		var xhtml = new XMLHttpRequest();
		var url = "http://localhost:8080/api/files";
		xhtml.open("GET", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		xhtml.send();
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				var data = JSON.parse(this.responseText);
				var display = document.getElementById("display");
				var table = "<table border=1>";
				table += "<tr> <th>File Name</th> <th>Size (bytes)</th> <th>Action</th> </tr>";
				for(var x in data)
				{
					table += "<tr> <td>"+ data[x].filename +"</td> <td>"+ data[x].filesize +"</td> <td> <a href='"+ data[x].path + data[x].filename +"'>download</a></td> </tr>";
				}
				display.innerHTML = table;
			}
		};
	}
</script>
</html>