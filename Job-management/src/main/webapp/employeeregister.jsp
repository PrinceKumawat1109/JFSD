<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee-Register</title>
<style>
.card{
height: 950px;
width: 700px;
border-style: solid;
margin-left: 400px;
}

</style>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	
	<div class="card">
	<h1 style=" color: red; margin-left: 250px;">New Account</h1>
	<h3 style="margin-left: 50px; margin-top: 50px;">Not our registered yet?</h3>
	<h5 style="margin-left: 50px; margin-top: 20px;">If you have any questions, please feel free to contact us, our customer service center is working for you 24/7.</h5>
	<h3 style="margin-left: 50px; margin-top: 50px;">UserName</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="box" id="t1"/>
	
	
	<h3 style="margin-left: 50px; margin-top: 50px;">E-mail</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="box" id="t2"/>
	
	
	<h3 style="margin-left: 50px; margin-top: 50px;">First Name</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="box" id="t3"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Last Name</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="box" id="t4"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Password</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="box" id="t5"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Gender</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="box" id="t6"/>
	<div style="margin-top: 50px; margin-left: 300px;" class="butt">
	<button style="height: 35px; width: 75px;"  onclick="save()">Sign-Up</button>
	</div>
	<label id="lbl"></label>
	
	</div>
</body>
<script type="text/javascript">
function save()
{
	var xhtml = new XMLHttpRequest();
	var url = "https://app-0011.azurewebsites.net//api/register";
	xhtml.open("POST", url, true);
	xhtml.setRequestHeader('Content-Type','application/json');
	
	var t1 = document.getElementById("t1");
	var t2 = document.getElementById("t2");
	var t3 = document.getElementById("t3");
	var t4 = document.getElementById("t4");
	var t5 = document.getElementById("t5");
	var t6 = document.getElementById("t6");
	var lbl = document.getElementById("lbl");
	
	xhtml.send(JSON.stringify({
		username : t1.value,
		fname : t2.value,
		lname : t3.value,
		email : t4.value,
		pwd : t5.value,
		gender : t6.value
	}));
	
	xhtml.onreadystatechange = function()
	{
		if(this.readyState == 4 && this.status == 200)
			lbl.innerText = this.responseText;
			window.location="https://app-0011.azurewebsites.net//employeelogin.jsp";

	};
}
</script>
</html>