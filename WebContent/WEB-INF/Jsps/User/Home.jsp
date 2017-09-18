<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<style>
body { 
    background-image: url('img/all.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>
    

<title>Home Page</title>
</head>
<body>
<header> <jsp:include page="../header.jsp"/> </header>

<center>
<h3 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h3>

</center>

<footer> <jsp:include page="../footer.jsp"/> </footer>
</body>
</html>