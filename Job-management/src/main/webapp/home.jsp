<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Home</title>
	<jsp:include page="navbar.jsp" />
</head>
<style>
body{
    background-image: url('meeting.jpg');
   
    background-size: cover;
    
}
.box{
height: 300px;
width: 600px;
background-color: white;
margin-left: 450px;
margin-top: 50px;
}
h4{
margin-left: 50px;
margin-top: 100px;
}
.location h4{
margin-left: 330px;
margin-top: -45px;

}
.card{
height:500px;
width: 400px;
background-color: white;
margin-left: 200px;
margin-top: 100px;
}
</style>
<body>

<div class="box">
<br><br>
<h1 style="margin-left: 150px;">Find a Job You will Love</h1>
<hr style="width: 100px; background-color: red; margin-left: 250px; margin-top: 20px;">
<h4>Position</h4>
<div class="kk" style="margin-left: 50px;">
<input style="height: 25px; width: 200px;"  type="box"  placeholder="position you are looking for">
</div>

<div class="location">
<h4>Location</h4>
<div class="ii">
<input style="height: 25px; width: 200px; margin-left: 330px; "  type="box" placeholder="Any particular location ?">
</div>
</div>
<div class="search">
<a href="facebook.com"><i class="fa fa-search" style="margin-top: 10px; font-size:26px; margin-left: 280px;"></i></a>
</div>
</div>

<!-- <div class="card">
<a href="instagram.com"><img src="meeting.jpg" style="height: 250px; width: 400px;"></a>
<p>LEARN LARAVEL WITH VUE2
 DHAKA, BANGLADESH FULL TIME

Some additional info for this screen about validity of the ads</p>

</div>

<div class="card">
<a href="instagram.com"><img src="meeting.jpg" style="height: 250px; width: 400px;"></a>
<p>LEARN LARAVEL WITH VUE2
 DHAKA, BANGLADESH FULL TIME

Some additional info for this screen about validity of the ads</p>

</div>

<div class="card">
<a href="instagram.com"><img src="meeting.jpg" style="height: 250px; width: 400px;"></a>
<p>LEARN LARAVEL WITH VUE2
 DHAKA, BANGLADESH FULL TIME

Some additional info for this screen about validity of the ads</p>-->

</div>
</body>
</html>