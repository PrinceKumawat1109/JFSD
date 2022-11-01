<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSON Demo</title>
</head>
<body>
	<h3>Arithmetic Operations using JSON</h3>
	<p>Input A: <input type="text" id="t1" /> </p>
	<p>Input B: <input type="text" id="t2" /> </p>
	<p>
		Addition = <label id="r1"></label> , 
		Subtraction = <label id="r2"></label>
	</p>
	<button onclick="callService()">callService</button>
</body>
<script type="text/javascript">
	function callService()
	{
		var xhttp = new XMLHttpRequest();
		var url = "http://localhost:8080/jfsd002/CalculatorService";
		
		var t1 = document.getElementById("t1");
		var t2 = document.getElementById("t2");
		var r1 = document.getElementById("r1");
		var r2 = document.getElementById("r2");
		
		var jsonData = "{\"A\":" + t1.value + ", \"B\":" + t2.value + "}";
		xhttp.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status == 200)
			{
				//alert(this.responseText);
				var obj =JSON.parse(this.responseText);
				r1.innerText = obj.SUM;
				r2.innerText = obj.SUB;
			}
		};
		xhttp.open("POST", url, true);
		xhttp.send(jsonData);
	}
</script>
</html>