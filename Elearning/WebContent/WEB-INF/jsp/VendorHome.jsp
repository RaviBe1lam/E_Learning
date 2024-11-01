<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body style="height:100vh;color:white;background-image: url('images/Photo3.jpg');background-size: 100% 100%;">

<h1 class="title">Welcome to Vendor Dashboard</h1>
<%
User user=(User)session.getAttribute("user");
%>
<a href="Logout" class="logout">Log Out</a>
<h2>Welcome <%=  user.getName() %></h2>

	<a class="btn" href="VendorProfile">Profile</a>
	<a class="btn" href="Orders">Orders</a>
	<a class="btn" href="Products">Products</a>
	<a class="btn" href="SearchCourse">Search Products</a>

</body>
</html>