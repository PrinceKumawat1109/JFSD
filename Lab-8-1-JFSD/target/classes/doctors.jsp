<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab-8</title>
</head>
<body>
	<h3>KL - Hospital Doctors</h3>
	<p>Doctor Id : <input type="text" id="t1" required/></p>
	<p>Full Name : <input type="text" id="t2" required/></p>
	<p>Graduation Details : <input type="text" id="t3" required/></p>
	<p>Age : <input type="text" id="t4" required/></p>
	<p>Gender : <input type="radio" id="t5" value="Male" required/>Male   
				<input type="radio" id="t5" value="Female" required/>Female</p>
	<p>Address: </p><textarea id="t6" rows="4" cols="50" required></textarea>
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
		var url = "http://localhost:8080/api/doctor";
		xhtml.open("POST", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		var t1 = document.getElementById("t1");
		var t2 = document.getElementById("t2");
		var t3 = document.getElementById("t3");
		var t4 = document.getElementById("t4");
		var t5 = document.getElementById("t5");
		var t6 = document.getElementById("t6");
		
		xhtml.send(JSON.stringify({
			id : t1.value,
			name : t2.value,
			graduation : t3.value,
			age : t4.value,
			gender : t5.value,
			address : t6.value
		}));
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
				lbl.innerText = "Data Inserted Successfully...!";
		};
	}
	
	function update()
	{
		var xhtml = new XMLHttpRequest();
		var t1 = document.getElementById("t1");
		var t2 = document.getElementById("t2");
		var t3 = document.getElementById("t3");
		var t4 = document.getElementById("t4");
		var t5 = document.getElementById("t5");
		var t6 = document.getElementById("t6");
		var url = "http://localhost:8080/api/doctor/"+t1.value;
		xhtml.open("PUT", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		xhtml.send(JSON.stringify({
			id : t1.value,
			name : t2.value,
			graduation : t3.value,
			age : t4.value,
			gender : t5.value,
			address : t6.value
		}));
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
				lbl.innerText = "Data Updated Successfully...!";
		};
	}
	
	function del()
	{
		var xhtml = new XMLHttpRequest();
		var t1 = document.getElementById("t1");
		var url = "http://localhost:8080/api/doctor/" + t1.value;
		xhtml.open("DELETE", url, true);
		xhtml.setRequestHeader('Content-Type','application/json');
		
		var lbl = document.getElementById("lbl");
		
		xhtml.send();
		
		xhtml.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
				lbl.innerText = this.responseText;
		};
	}
</script>
</html>