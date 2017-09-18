<%@page import="in.codertechnologies.pettycash.dao.impl.DailyDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    

<style>
body { 
    background-image: url('img/teaWithRecipts.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<title>Show Daily Details Page </title>

<script type="text/javascript" src="scripts/jquery-3.0.0.min.js"></script>
<script type="text/javascript">

	$(document).ready(function()
	{
		
		$("#productName").keyup(function() 
		{
			$.get("daily", 
			{
				action : "searchProductName",
				productName : $("#productName").val()
			},
			function(li) 
			{
				$("#tb").empty();
				$.each(li,function (idx,obj)
				{
					$("#tb").append("<tr><td>" +obj.daily.did +"</td><td>" +obj.daily.date1 +"</td><td>" +obj.product.productName +"</td><td>" +obj.daily.productPrice +"</td><td>" +obj.daily.productQuantity +"</td><td>" +obj.daily.productTotal +"</td><td><a href=daily?action=update&did="+ obj.daily.did  +">Update</a></td><td><a href=daily?action=delete&did="+ obj.daily.did  +">Delete</a></td></tr>");
					
					
				});		
				});
			});
		});
	
	$(document).ready(function()
			{
				
		$("#date1").keyup(function() 
 				{
 					$.get("daily", 
 					{
 						action : "searchDate",
 						date1 : $("#date1").val(),
 					},
 					function(li) 
 					{
 
 						$("#tb").empty();
 						$.each(li,function (idx,obj)
 						{
 							$("#tb").append("<tr><td>" +obj.daily.did +"</td><td>" +obj.daily.date1 +"</td><td>" +obj.product.productName +"</td><td>" +obj.daily.productPrice +"</td><td>" +obj.daily.productQuantity +"</td><td>" +obj.daily.productTotal +"</td><td><a href=daily?action=update&did="+ obj.daily.did  +">Update</a></td><td><a href=daily?action=delete&did="+ obj.daily.did  +">Delete</a></td></tr>");
					
 						});		
 						});
 					});
 				});
			
</script>
</head>
<body>

<header> <jsp:include page="../header.jsp"/> </header>

<center>
<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>

 <input type="text" name="date1" id="date1" placeholder="Search yyyy-mm-dd " class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"><br>

<input type="text" name="productName" id="productName" placeholder="Search by product" class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"><br><br>

<table border =2 class="w3-table-all w3-centered" style="width: 50%; margin: 2px; padding: 2px">
	<thead>
		<tr class="w3-green">

			<th>Id</th>
			<th>Date</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<th>Product Total</th>
			
			<c:if test="${uname ne null }">
			<th>Edit</th>
			<th>Delete</th>
	</c:if>
			</tr>
	</thead>
	
		<tbody id="tb">
		
		<c:forEach var="daily" items="${showDetailsDaily}">
			<tr class="w3-hover-grey">

				<td>${ daily.did }</td>
				<td><fmt:formatDate value="${daily.date1}"  dateStyle="medium"/></td>
				<td>${ daily.dailyProduct.productName}</td>
				<td>${ daily.productPrice }</td>
				<td>${ daily.productQuantity }</td>
				<td>${ daily.productTotal }</td>
				
				<c:if test="${uname ne null }">
				<td><a href='<c:url value="daily?action=update&did=${daily.did}"/>'>Update</a></td>
				<td><a href='<c:url value="daily?action=delete&did=${daily.did}"/>'>Delete</a>
				</td>
				</c:if>
				
			</tr>

		</c:forEach>
	</tbody>
	</table>
	
	<table border="0" cellpadding="0" cellspacing="0">
     <td>
 <%--For displaying Previous link except for the 1st page --%>
    <h2 style="font-family:Times new roman;font-size:20px;color:orange">
    <c:if test="${noOfPages gt 1 and offset ne 0}">
       <!--  <td> --><a href="daily?action=ShowDetailsDaily&p=prev">&nbsp;Previous</a><!-- </td> -->
    </c:if>
   <%--  <%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
    <!-- <table border="1" cellpadding="5" cellspacing="5"> -->
       <!--  <tr> -->
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <!-- <td> -->${i}&nbsp;&nbsp;<!-- </td> -->
                    </c:when>
                    <c:otherwise>
                       <!--  <td> --><a href="daily?action=ShowDetailsDaily&p=pages">${i}&nbsp;</a><!-- </td> -->
                    </c:otherwise>
                </c:choose>
            </c:forEach>
       <!--  </tr> -->
   
   

    <c:if test="${ offset lt noOfRecords-5 }">
      <a href="daily?action=ShowDetailsDaily&p=next">&nbsp;Next</a>
    </c:if>
    
    </h2>
    </td>

  </table>
	
</center>
</body>
</html>