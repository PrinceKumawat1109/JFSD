<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<jsp:include page="navbar2.jsp" />

</head>
<body onload="review()">
	<div>
	<h1 style="margin-left: 700px; margin-top: 100px;">DASHBOARD</h1>
	</div>
	
	<div style="margin-left: 200px; margin-top: 300px;">
	
	<label id="lbl"></label>
<div style="width:100%" id="display" ></div>
	<a style="margin-left: 1200px; " href="newposition.jsp"><button style="height: 35px; width: 100px;">Add a new position</button></a>
	
	   <!-- <h4>Job Title</h4>
	   

	   <h4 style="margin-left: 150px; margin-top: -20px;">Position filled</h4>
	   
	   <h4 style="margin-left: 350px; margin-top: -19px;">Date posted	</h4>
	   
	   <h4 style="margin-left: 550px; margin-top: -18px;">Date expiring</h4>
	   
	   <h4 style="margin-left: 750px; margin-top: -17px;">Applicants</h4>
	   
	   <h4 style="margin-left: 950px; margin-top: -16px;">Actions</h4>
	   <hr style="margin-left: -300px;">  href='http://localhost:8080/new/eregister/"+data[x].jobtitle+"' -->
	</div>
</body>
<script type="text/javascript">
function review()
{
  var xhtml = new XMLHttpRequest();
    var url="https://app-0011.azurewebsites.net/api/new/register";
    xhtml.open("GET", url, true);
    xhtml.setRequestHeader('Content-Type','application/json');
    
    xhtml.send();
    
    var display = document.getElementById("display");
    
    xhtml.onreadystatechange = function()
    {
      if(this.readyState == 4 && this.status == 200)
      {
        var table = "<table border='1'>";
        var i=0;
        table += 
          "<tr>"+
          "<th>S.No</th>"  +
          "<th>JoB Title</th>"+
          "<th>JoB Description</th>" +
          "<th>Location</th>" +
          "<th>Type</th>" +
          "<th>Category</th>"+
          "<th>URL</th>"+
          "<th>Date</th>"+
          "<th>company name</th>"+
          "<th>Comdes</th>"+
          "<th>website</th>"+
          "<th>Delete</th>"+
          "</tr>";
        var data = JSON.parse(this.responseText);
        for(var x in data)
        {
          table=table+
          "<tr>"+
            "<td>"+ (i+1) +"</td>"+
            "<td>"+ data[x].jobtitle+"</td>"+
            "<td>"+ data[x].jobdes+"</td>"+
            "<td>"+ data[x].loc+"</td>"+
            "<td>"+ data[x].type+"</td>"+
            "<td>"+ data[x].category+"</td>"+
            "<td>"+ data[x].url+"</td>"+
            "<td>"+ data[x].date+"</td>"+
            "<td>"+ data[x].comname+"</td>"+
            "<td>"+ data[x].comdes+"</td>"+
            "<td>"+ data[x].website+"</td>"+
            "<td><button onclick=\"timeout('"+data[x].jobtitle+"')\">delete</button></td>"+
          "</tr>";
          i++;
        }
        table=table+"</table>";
        display.innerHTML = table;
      }
    };
}
function timeout(job)
{
	var xhtml = new XMLHttpRequest();
	  var url="https://app-0011.azurewebsites.net/api/new/eregister/"+job;
	  alert(url);
	  xhtml.open("DELETE", url, true);
	  xhtml.setRequestHeader('Content-Type','application/json');
	  xhtml.send();
	  xhtml.onreadystatechange = function()
	  {
	    if(this.readyState == 4 && this.status == 200)
	         window.location.reload();
	  };
}
</script>
</html>