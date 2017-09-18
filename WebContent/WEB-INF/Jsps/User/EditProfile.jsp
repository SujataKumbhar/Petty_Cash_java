<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
    
<title>Edit Profile page</title>
</head>

<script type="text/javascript" src="scripts/jquery-3.0.0.min.js">
	
</script>

<script type="text/javascript">
	function validate() {
		var frm = document.forms["myForm"];

		if (frm.oldpass.value == "" && frm.newpass.value == ""
				&& frm.renewpass.value == "") {
			alert("All Data Should Write Mendatory");
			frm.complusory.focus();
			    return false;
		}

		if (frm.oldpass.value == "") {
			alert("Please write your OldPass");
			frm.oldpass.focus();
			  return false;
		}

		if (frm.newpass.value == "") {
			alert("Please write your New Password");
			frm.newpass.focus();
			  return false;
		}

		if (frm.renewpass.value == "") {
			alert("Please write your Retype Password");
			frm.renewpass.focus();
			  return false;
		}

		if (frm.renewpass.value != frm.newpass.value) {
			alert("Password Does Not match");
			frm.myForm.focus();
			return false;
		} else

			return (true);
	}
</script>
<body>
<center>
<header> <jsp:include page="../header.jsp"/> </header>

	<h4 style="color:red;"> ${NotchangePassword} </h4>
		
	<c:url value="user" var="url" />

	<form action="${url}" name="myForm" onsubmit="return(validate());"
		method="post">

		<table class="w3-table-all" style="margin-left:30px;width:600px">


			<tr>
				<td> <h2 style="font-family:Centaur;font-size:40px;color:blue">Old Password </h2></td>
				<td><input type="password" name="oldpass" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green" /></td>
			</tr>

			<tr>
				<td> <h2 style="font-family:Centaur;font-size:40px;color:blue">New Password </h2></td>
				<td><input type="password" name="newpass" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green" /></td>
			</tr>

			<tr>
				<td><h2 style="font-family:Centaur;font-size:40px;color:blue">ReEnter Password</h2></td>
				<td><input type="password" name="renewpass" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"/></td>
			</tr>

			<tr>
				<td><input type="hidden" name="action" value ="EditProfile"></td>
				<td><input type="submit" name="complusory" value="Edit" class="w3-button w3-green w3-border w3-border-red w3-round-large" style="margin-left:50px"/></td>
			</tr>


		</table>
	</form>
</center>
</body>
</html>