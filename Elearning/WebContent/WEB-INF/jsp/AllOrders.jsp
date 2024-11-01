<%@page import="dao.OrderDAO"%>
<%@page import="model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
<h3 class="title">All Orders List</h3>
<a href="AdminHome" class="btn">Home</a>	
<a class="btn" href="CreateUser">Create User</a>
	<a class="btn" href="AllProducts">All Courses</a>
	<a class="btn" href="SearchCourse">Search Courses</a>
	<a class="btn" href="Products">view/add Courses</a>
	<a class="btn" href="Logout">Log Out</a>
	<br>
	<a class="btn" href="AdminHome">All Users</a>
	<a class="btn" href="AdminHome?role=LNR">Learners</a>
	<a class="btn" href="AdminHome?role=VND">Vendors</a>
	
	<table class="table">
	<tr>
		<th>Order No</th>
		<th>Course Code</th>				
		<th>User ID</th>
		<th>Order Date</th>		
	</tr>
	<%		
	for(Order c : OrderDAO.getAllOrders()) { %>
	<tr>
	<td><%= c.getOrderno() %></td>
	<td><%= c.getCcode() %></td>
	<td><%= c.getUserid() %></td>
	<td><%= c.getPur_date() %></td>
	</tr>
	 <% } %>
</table>
</body>
</html>