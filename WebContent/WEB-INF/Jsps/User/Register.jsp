<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<style>
body { 
    background-image: url('img/register.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>
    

<title>Register</title>
</head>
<body>
<header> <jsp:include page="../header.jsp"/> </header>
<center>

<c:url value="user" var="url"/>

<form action="${url}" method ="POST">
<br/>

<h2 style="font-family:Centaur;font-size:40px;color:blue">UserName</h2>

<input type="text" name="uname" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"/><br/> 

<h2 style="font-family:Centaur;font-size:40px;color:blue">Password </h2>
<input type="password" name="pass" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"/><br/>

	
	<input type="submit" value="Register" class="w3-button w3-green w3-border w3-border-red w3-round-large"><br/>
	<input type="hidden" name="action" value="Register"><br/>
</form>
<footer> <jsp:include page="../footer.jsp"/> </footer>
</center>
</body>
</html>