<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E learning Management</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
  <body style="background-image:url('images/Photo3.jpg');   background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;">
     <h1 class="title"> E Learning Management</h1>
	<h2 class="title">Welcome to Login Page</h2>
	
	<form action="Validate" style="margin-top:20px;" method="post">
		<b></b><label class="label" for="userid">User Name :</label>
		<input id="userid" class="controls"
		placeholder="Email ID" 
		required name="userid" type="email"><br></b>
		
		<label class="label" for="pwd">Password :</label>
		<input id="pwd" class="controls" name="pwd"
		placeholder="Password" 
		required type="password"><br>
		
		<label class="label" for="role">Select Role :</label>
		<select id="role" class="controls" name="role">
			<option value="ADM">Administrator</option>
			<option value="LNR">Learner</option>
			<option value="VND">Vendor</option>
		</select><br>
		
		<input class="btn" type="submit" value="Login">
	</form><br>
	<%
	if(session.getAttribute("success")!=null){
		%>
		<div class="success"><%= session.getAttribute("success") %></div>
		<%
		session.removeAttribute("success");
	}
	%>
	<%
	if(session.getAttribute("error")!=null){
		%>
		<div class="error"><%= session.getAttribute("error") %></div>
		<%
		session.removeAttribute("error");
	}
	%>
	<h3 style="color:red">Not registered click<a class="link"  title="registration page" href="SignUp">here</a></h3>
</body>
</html>