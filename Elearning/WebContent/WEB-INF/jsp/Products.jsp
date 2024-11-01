<%@page import="model.User"%>
<%@page import="dao.CourseDAO"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products Module</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
<h3 class="title">My Products/Courses</h3>
<%
User u=(User)session.getAttribute("user");
if(u.getRole().equals("VND")){
%>
<a href="VendorHome" class="home">Home</a>
<%} else { %>
<a href="AdminHome" class="btn">Home</a>
<a class="btn" href="CreateUser">Create User</a>
	<a class="btn" href="AllProducts">All Courses</a>
	<a class="btn" href="AllOrders">All Orders</a>
	<a class="btn" href="SearchCourse">Search Courses</a>
	<a class="btn" href="Logout">Log Out</a>
	<br>
	<a class="btn" href="AdminHome">All Users</a>
	<a class="btn" href="AdminHome?role=LNR">Learners</a>
	<a class="btn" href="AdminHome?role=VND">Vendors</a>
	
<% } %>
<a href="CreateProduct" class="home"><h4 style="color:yellow;">Add New Course</h4></a>
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
	
	String userid=u.getEmail();
	for(Course c : CourseDAO.getUserCourse(userid)) { %>
	<tr>
	<td><%= c.getCcode() %></td>
	<td><%= c.getCname() %></td>
	<td><%= c.getDuration() %> month</td>
	<td>&#8377; <%= c.getAmount() %></td>
	<td><%= c.getActive() %></td>
	<td><a style="margin:0" href="EditProduct?ccode=<%= c.getCcode() %>" class="btn">Change</a></td>
	</tr>
	 <% } %>
</table>
</body>
</html>