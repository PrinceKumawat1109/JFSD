<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style>
.card{
height: 1500px;
width: 600px;
border-style: solid;
margin-left: 450px;
}
.i{
margin-top: 10px;
margin-left: 50px;
}
</style>
</head>

<jsp:include page="navbar2.jsp" />
<body>
<div class="card">
	<h1 style=" color: red; margin-left: 100px;">Update Position</h1>
<h3 style="margin-left: 50px; margin-top: 50px;">Job Description</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t1"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Location</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t2"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Job-Type</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t3"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Category</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t4"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Url</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t5"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Date</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t6"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Company Name</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t7"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Company Description</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t8"/>
	<h3 style="margin-left: 50px; margin-top: 50px;">Website Url</h3>
	<input style="margin-left: 50px; margin-top: 20px; height: 25px; width: 250px;" type="text" id="t9"/>
	<div class="i">
	<button style="height: 35px; width: 75px;"  onclick="update()">Update</button>
	<label id="lbl"></label>
	</div>
	
</div><script type="text/javascript">
function update()
{
	let urlString=window.location.href;
	let paramString = urlString.split('?')[1];
	let queryString = new URLSearchParams(paramString);
	var url1;
	for(let pair of queryString.entries()) 
	{
	   url1 = "http://localhost:8080/api/new/eregister/"+pair[1];
	}
	var xhtml = new XMLHttpRequest();
	//var url = "https://app-0011.azurewebsites.net/new/eregister/"+sessionStorage.getItem("jobtitle");
	xhtml.open("PUT", url1, true);
	xhtml.setRequestHeader('Content-Type','application/json');
	var t1 = document.getElementById("t1");
	var t2 = document.getElementById("t2");
	var t3 = document.getElementById("t3");
	var t4 = document.getElementById("t4");
	var t5 = document.getElementById("t5");
	var t6 = document.getElementById("t6");
	var t7 = document.getElementById("t7");
	var t8 = document.getElementById("t8");
	var t9 = document.getElementById("t9");	
	var lbl = document.getElementById("lbl");
	alert(url1);
	xhtml.send(JSON.stringify({
		jobdes : t1.value,
		loc : t2.value,
		type : t3.value,
		category : t4.value,
		url : t5.value,
		date : t6.value,
		comname : t7.value,
		comdes : t8.value,
		website : t9.value
	}));
	xhtml.onreadystatechange = function()
	{
		if(this.readyState == 4 && this.status == 200)
			lbl.innerText = "Data Updated Successfully...!";
	};
}
</script>
</body>
</html>