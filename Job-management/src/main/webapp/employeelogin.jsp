<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login</title>
<style>
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
height: 400px;
width: 400px;
border-style: solid;
margin-left: 600px;
}
.i{
margin-top: 10px;
margin-left: 50px;
}
</style>
</head>
<jsp:include page="navbar3.jsp" />
<body>
<div class="card">
	<h1 style=" color: red; margin-left: 100px;">Employee Login</h1>
<h3 style="margin-left: 50px; margin-top: 50px;">Username</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t1"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Password</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="password" id="t2"/>
	<div class="i">
	<button style="height: 35px; width: 75px;"  onclick="login()">Login</button>
	<label id="lbl"></label>
	</div>
</div>
</body>
<script type="text/javascript">
function login()
{
	var xhtml = new XMLHttpRequest();
	var t1 = document.getElementById("t1");
	var t2 = document.getElementById("t2");
	var url = "https://app-0011.azurewebsites.net/api/register/login/"+t1.value+"/"+t2.value;
	xhtml.open("POST", url, true);
	xhtml.setRequestHeader('Content-Type','application/json');
	
	
	var lbl = document.getElementById("lbl");
	
	xhtml.send();
	
	xhtml.onreadystatechange = function()
	{
		if(this.readyState == 4 && this.status == 200)
			sessionStorage.setItem("username",t1.value);
			lbl.innerText = this.responseText;
			window.location="https://app-0011.azurewebsites.net/findajob2.jsp";

	};
}
</script>
</html>