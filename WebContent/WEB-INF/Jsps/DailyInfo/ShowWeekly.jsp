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


<title>Show Weekly Pages</title>
</head>
<body>
<center>

<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>
<table border="1" class="w3-table-all w3-centered" style="width: 50%; margin: 2px; padding: 2px">
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
		
		<c:forEach var="daily" items="${ShowWeekly}">
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
       <!--  <td> --><a href="daily?action=ShowWeekly&p=prev">&nbsp;Previous</a><!-- </td> -->
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
                       <!--  <td> --><a href="daily?action=ShowWeekly">${i}&nbsp;</a><!-- </td> -->
                    </c:otherwise>
                </c:choose>
            </c:forEach>
       <!--  </tr> -->
   
   

    <c:if test="${ offset le noOfRecords-5 }">
      <a href="daily?action=ShowWeekly&p=next">&nbsp;Next</a>
    </c:if>
       </h2>
    </td>
    
  </table>
	
</center>

</body>
</html>