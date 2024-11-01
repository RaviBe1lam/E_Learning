<%@page import="model.User"%>
<%@page import="dao.CourseDAO"%>
<%@page import="model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Course</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
<% User user=(User)session.getAttribute("user"); %>
	<h2 class="title">Course Searching</h2>
	<% if(user.getRole().equals("ADM")) { %>
	<a href="AdminHome" class="btn">Home</a>
	<a class="btn" href="CreateUser">Create User</a>
	<a class="btn" href="AllProducts">All Courses</a>
	<a class="btn" href="AllOrders">All Orders</a>
	<a class="btn" href="Products">view/add Courses</a>
	<a class="btn" href="Logout">Log Out</a>
	<br>
	<a class="btn" href="AdminHome">All Users</a>
	<a class="btn" href="AdminHome?role=LNR">Learners</a>
	<a class="btn" href="AdminHome?role=VND">Vendors</a>
	
	<% } else if(user.getRole().equals("LNR")) { %>
	<a href="LearnerHome" class="home">Home</a>
	<% } else if(user.getRole().equals("VND")) { %>
	<a href="VendorHome" class="home">Home</a>
	<% } %>
	<form method="get" style="margin-bottom:10px;">
		<input type="search" placeholder="Search for courses" 
		name="cname" value="${param.cname }"
			required style="padding: 10px; width: 500px"> 
	<input style="padding:10px 20px;background-color:blue;color:white;border:none;"
			type="submit" value="Search" name="search">
	</form>
	<%
		if (request.getParameter("search") != null) {
			%>
			<h4 style="text-align:center;padding:10px;border-bottom:2px double black;margin-bottom:10px;">Search Result</h4>
			<%
			String cname = request.getParameter("cname");
			List<Course> list = null;
			if(user.getRole().equals("VND")){
				list=CourseDAO.searchUserCourse(user.getEmail(), cname);
			}else{
				list=CourseDAO.searchCourses(cname);	
			}
			if (list.size() > 0) {
				%>
				<table class="table">
				<tr>
				<th>Course Code</th>
				<th>Course Name</th>
				<th>Vendor ID</th>
				<th>Duration</th>				
				<th>Course Fees</th>
				</tr>
				<%
				for (Course c : list) {
					%>
					<tr>
					<td><%= c.getCcode() %></td>
					<td><%= c.getCname() %></td>
					<td><%= c.getUserid() %>
					<td><%= c.getDuration() %> months</td>
					<td>&#8377; <%= c.getAmount() %></td>					
					</tr>
					<%
				}
				%>
				</table>
				<% 
			} else {
	%>
	<h3>No such course found</h3>
	<%
		}
		}
	%>
</body>
</html>