<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">


<style>
body { 
    background-image: url('img/receipts.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>


<title>Show Monthly Page</title>
</head>
<body background = "img/all.jpg">
<script type="text/javascript" src="scripts/jquery-3.0.0.min.js">
	
</script>
<script>
	$(document).ready(function()
			{
				
				$("#date1").keyup(function() 
				{
					$.get("daily", 
					{
						action : "searchMonth",
						date1 : $("#date1").val(),
					},
					function(li) 
					{
						
						$("#tb").empty();
						$.each(li,function (idx,obj)
						{
							$("#tb").append("<tr><td><a href=''>"+ obj.daily.date1 +"</a>"+"</td><td>" +obj.daily.productTotal +"</td></tr>");
					
						});		
						});
					});
				});

	
</script>


<title>Show Monthly Page</title>
</head>
<body>
<center>
<header> <jsp:include page="../header.jsp"/> </header>

<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>

<input type="text" name="date1" id="date1" placeholder="yyyy-mm" class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"><br><br>

<table border =2 class="w3-table-all w3-centered" style="width: 50%; margin: 2px; padding: 2px">
	<thead>
		<tr class="w3-green">

			
			<th>Date</th>
			<th>All Total</th>
			
	
			</tr>
			</thead>
	<fmt:formatDate value="${ daily.date1}"  dateStyle="medium"/>
	
	<tbody id="tb">
		
		<c:forEach var="daily" items="${ShowMonthly}">
			<tr class="w3-hover-grey">

				<td><a href="daily?action=ShowDetailsParticularMonth&date1=${ daily.date1}"><fmt:formatDate value="${ daily.date1}" pattern="YYYY-MM"/></a></td>
				
			
				<td>${ daily.productTotal }</td>
				
			</tr>

		</c:forEach>
	</tbody>
	
</table>
<footer> <jsp:include page="../footer.jsp"/> </footer>
</center>
</body>
</html>