<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employer-Register</title>
<style type="text/css">
h2{
text-align : center;
font-size : 35px;
}

.first
{
margin-left: 650px;
margin-top: 50px;
}
button
{
margin-left:100px;
margin-top:20px;
}
.card{
height: 600px;
width: 700px;
border-style: solid;
margin-left: 400px;
}
.i{
margin-top: 10px;
margin-left: 170px;
}
</style>
</head>
	<jsp:include page="navbar.jsp" />
<body>
<div class="card">
	<h1 style=" color: red; margin-left: 250px;">Employer Register</h1>
<h3 style="margin-left: 50px; margin-top: 50px;">E-mail</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t1"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Company Name</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t2"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Company Address</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t3"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Password</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="password" id="t4"/>
	<div class="i">
	<button style="height: 35px; width: 75px;"  onclick="save()">Sign-Up</button>
	</div></div>
	<label id="lbl"></label>
</div>
<!--<h2>Employer Register</h2>
<div class="first">
	<p>E-mail : <input type="text" id="t1"/></p>
	<br/>
	<p>Company Name : <input type="text" id="t2"/></p>
	<br/>
	<p>Company Address : <input type="text" id="t3"/></p>
	<br/>
	<p>Password : <input type="password" id="t4"/></p>
	
	<button onclick="save()">Sign-up</button>
	<label id="lbl"></label>
	</div>-->
</body>
<script type="text/javascript">
function save()
{
	var xhtml = new XMLHttpRequest();
	var url = "https://app-0011.azurewebsites.net/api/eregister/";
	xhtml.open("POST", url, true);
	xhtml.setRequestHeader('Content-Type','application/json');
	
	var t1 = document.getElementById("t1");
	var t2 = document.getElementById("t2");
	var t3 = document.getElementById("t3");
	var t4 = document.getElementById("t4");
	var lbl = document.getElementById("lbl");
	
	xhtml.send(JSON.stringify({
		email : t1.value,
		com_name : t2.value,
		com_add : t3.value,
		pwd : t4.value
	}));
	
	xhtml.onreadystatechange = function()
	{
		if(this.readyState == 4 && this.status == 200)
			lbl.innerText = this.responseText;
			window.location="https://app-0011.azurewebsites.net/employerlogin.jsp";
	};
}
</script>
</html>