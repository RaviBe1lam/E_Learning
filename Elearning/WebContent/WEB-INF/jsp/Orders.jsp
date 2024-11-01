<%@page import="dao.OrderDAO"%>
<%@page import="model.Order"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders Page</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
<h3 class="title">Orders List</h3>
<a href="VendorHome" class="home">Home</a>	
	<table class="table">
	<tr>
		<th>Order No</th>
		<th>Course Code</th>				
		<th>User ID</th>
		<th>Order Date</th>		
	</tr>
	<%	
	User user=(User)session.getAttribute("user");
	for(Order c : OrderDAO.getVendorOrders(user.getEmail())) { %>
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