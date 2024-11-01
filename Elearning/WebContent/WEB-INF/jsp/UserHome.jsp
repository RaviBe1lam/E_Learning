<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learner Dashboard</title>
<link rel="stylesheet" href="css/elearning.css">
</head>

<body style="background-image:url('images/Photo3.jpg');   background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;">
  
<h1 class="title">Welcome to Learner Dashboard</h1>
<%
User user=(User)session.getAttribute("user");
%>
<a class="btn" href="Logout" style="float:right;text-decoration:none;">Log Out</a>
<h2>Welcome <%=  user.getName() %></h2>

	<a class="btn" href="UserProfile">Profile</a>
	<a class="btn" href="PHistory">Purchase History</a>
	<a class="btn" href="OnlineCourses">Online Course</a>
	<a class="btn" href="SearchCourse">Search Courses</a>
	
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
</body>
</html>