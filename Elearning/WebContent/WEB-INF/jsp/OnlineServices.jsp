<%@page import="model.Course"%>
<%@page import="dao.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Services</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
<a href="LearnerHome" class="home">Home</a>
<a class="btn" href="Logout" style="float:right;text-decoration:none;">Log Out</a>

<h1 class="title">Online Courses</h1>
<table class="table">
	<tr>
		<th>Course Code</th>
		<th>Course Name</th>
		<th>Duration</th>
		<th>Price(Rs.)</th>
		<th>Active</th>
		<th>Action</th>
	</tr>
	<%	
	for(Course c : CourseDAO.getAllCourses()) { %>
	<tr>
	<td><%= c.getCcode() %></td>
	<td><%= c.getCname() %></td>
	<td><%= c.getDuration() %> month</td>
	<td>&#8377; <%= c.getAmount() %></td>
	<td><%= c.getActive() %></td>
	<td><a style="margin:0" 
	href="Purchase?ccode=<%= c.getCcode() %>" class="btn">Purchase</a></td>
	</tr>
	 <% } %>
</table>
</body>
</html>