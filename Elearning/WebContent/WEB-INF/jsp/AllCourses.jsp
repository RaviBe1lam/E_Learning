<%@page import="dao.CourseDAO"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E Learning management</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body >
<h3 class="title">All Products/Courses</h3>
	<a href="AdminHome" class="btn">Home</a>

<a class="btn" href="CreateUser">Create User</a>
	<a class="btn" href="AllOrders">All Orders</a>
	<a class="btn" href="SearchCourse">Search Courses</a>
	<a class="btn" href="Products">view/add Courses</a>
	<a class="btn" href="Logout">Log Out</a>
	<br>
	<a class="btn" href="AdminHome">All Users</a>
	<a class="btn" href="AdminHome?role=LNR">Learners</a>
	<a class="btn" href="AdminHome?role=VND">Vendors</a>
	

<table class="table">
	<tr>
		<th>Course Code</th>
		<th>Course Name</th>
		<th>Vendor ID</th>
		<th>Duration</th>
		<th>Price(Rs.)</th>
		<th>Active</th>		
	</tr>
	<%	
	for(Course c : CourseDAO.getAllCourses()) { %>
	<tr>
	<td><%= c.getCcode() %></td>
	<td><%= c.getCname() %></td>
	<td><%= c.getUserid() %></td>
	<td><%= c.getDuration() %> month</td>
	<td>&#8377; <%= c.getAmount() %></td>
	<td><%= c.getActive() %></td>	
	</tr>
	 <% } %>
</table>

</body>
</html>