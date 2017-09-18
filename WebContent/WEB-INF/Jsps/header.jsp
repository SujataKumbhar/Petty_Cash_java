<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<style>
#mySlides
{
	background size : cover;
    -webkit-animation: pulse 60s infinite;
}
@-webkit-keyframes pulse { 
   
      0%   {background: #00FFFF}
      25%  {background: #87CEEB}
      50%  {background: #90EE90}
      75%  {background: #DB7093}
      
     
       
}

</style>

<meta http-equiv="refresh" content = "<%= session.getMaxInactiveInterval()%>; URL=user?action=timeout"> <!-- session is expired -->
<title>Header Page</title>
</head>
<body>
<center>

 <div id="mySlides">
	<h1 style="font-family:Constantia;font-size:50px;color:Red">Welcome to Pettycash</h1>
	</div>
	
	<div class="w3-bar w3-border w3-border-red w3-light-grey w3-margin-top" >
	
	
	<c:if test="${ uname eq null}" >
	<a href = '<c:url value="user?action=Login"/>' class="w3-bar-item w3-button w3-hover-green" >Login</a>
	</c:if>
	
	<c:if test= "${ uname ne null}" >
	<a href ='<c:url value="user?action=Home"/>' class="w3-bar-item w3-button w3-hover-green" >Home</a>
	 <a href ='<c:url value="user?action=editProfile"/>' class="w3-bar-item w3-button w3-hover-green" >Edit Profile</a>
	<a href = '<c:url value="user?action=Logout"/>' class="w3-bar-item w3-button w3-hover-green">Logout</a>
	<a href = "daily?action=addDaily" class="w3-bar-item w3-button w3-hover-green">Add Daily</a>
	<a href = "product?action=addProduct" class="w3-bar-item w3-button w3-hover-green">Add Products</a>
	<a href = "daily?action=ShowWeekly" class="w3-bar-item w3-button w3-hover-green"> Show Weekly</a>
	<a href = "<c:url value="product?action=showProducts"/>" class="w3-bar-item w3-button w3-hover-green">Show All Products</a>
	
	</c:if>
	
		<c:if test= "${isShowDaily eq false or isShowDaily eq null}" >
	<a href = "daily?action=ShowDaily" class="w3-bar-item w3-button w3-hover-green">Show Daily</a>
	</c:if>
	
	
	<c:if test= "${isShowDetailsDaily eq false or isShowDetailsDaily eq null}" >
	<a href = "daily?action=ShowDetailsDaily" class="w3-bar-item w3-button w3-hover-green"> Show Details Daily </a>
	</c:if>
	
	<c:if test= "${isShowMonthly eq false or isShowMonthly eq null}" >
	<a href = "daily?action=ShowMonthly" class="w3-bar-item w3-button w3-hover-green">Show Monthly</a>
	</c:if>
	
	<c:if test= "${isShowYearly eq false or isShowYearly eq null}" >
	<a href = "daily?action=ShowYearly" class="w3-bar-item w3-button w3-hover-green">Show Yearly</a>
	</c:if>

		
		<a href = "daily?action=AboutUs" class="w3-bar-item w3-button w3-hover-green">About Us</a>
		<a href = "daily?action=ContactUs" class="w3-bar-item w3-button w3-hover-green">Contact Us</a>
	
		
		
	</div>
</center>
</body>
</html>