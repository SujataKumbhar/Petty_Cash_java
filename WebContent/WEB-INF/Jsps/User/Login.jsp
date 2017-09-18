<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<style>
body { 
    background-image: url('img/login.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>
    

<title>Login Page</title>

<script>

function myFunction()

{
var x = new Date();
x.setDate(15);

var x1 = new Date();
x1.setDate(25);

var n = Date.now();
var a = new Date();
var dd = new Date(n).toString();

var ab = a.getDate();

if(dd==x||dd==x1)
{
alert("Please Pay Monthly Bills");
return false;
}
return true;
}

</script>


</head>
<body>

<center>
<header> <jsp:include page="../header.jsp"/> </header>


 <h4 style="color:red;">  ${Logoutmessage} </h4>

<h4 style="color:green;">   ${registerSuccess} </h4>

<h4 style="color:red;">    ${logInFailed} </h4>

<h4 style="color:green;">	 ${changePassword} </h4>



<c:url value="user" var="url"/>

 <form action="${url}" method="post"> 
  
<h2 style="font-family:Centaur;font-size:40px;color:blue">UserName </h2> 

<input type="text" name="uname" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"/><br/> 

<h2 style="font-family:Centaur;font-size:40px;color:blue">Password </h2>

<input type="password" name="pass" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"/><br/>

<input type="submit" value="Login" onclick="myFunction()" class="w3-button w3-green w3-border w3-border-red w3-round-large"/>  
<input type="hidden" name="action" value ="Login">

<br>
<c:url value="user?action=Register" var="register" /><br>
<a href="${register}" class="w3-button w3-white w3-border w3-border-red w3-round-large">Register</a>


</form>

<%
String s = (String)request.getAttribute("timeout");

if(s!=null)
{
	out.println("<script type='text/javascript'> alert('Session Time out Please Login Again')</script>");
}

%>


<footer> <jsp:include page="../footer.jsp"/> </footer>

</center>
</body>
</html>