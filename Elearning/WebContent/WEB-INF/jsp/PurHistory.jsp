<%@page import="dao.CourseDAO"%>
<%@page import="model.Course"%>
<%@page import="model.User"%>
<%@page import="dao.OrderDAO"%>
<%@page import="model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase History</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
	<a href="LearnerHome" class="home">Home</a>
	<a class="btn" href="Logout" style="float:right;text-decoration:none;">Log Out</a>
	
	<h1 class="title">Purchase History</h1>
	
	<table class="table">
	<tr>
		<th>Order No</th>
		<th>Course Code</th>
		<th>Course Name</th>						
		<th>Order Date</th>		
	</tr>
	<%	
	User user=(User)session.getAttribute("user");
	for(Order c : OrderDAO.getUserOrders(user.getEmail())) { 
	Course cc=CourseDAO.findCourse(c.getCcode());
	%>
	<tr>
	<td><%= c.getOrderno() %></td>
	<td><%= c.getCcode() %></td>	
	<td><%= cc.getCname() %></td>
	<td><%= c.getPur_date() %></td>
	</tr>
	 <% } %>
</table>
	
</body>
</html>