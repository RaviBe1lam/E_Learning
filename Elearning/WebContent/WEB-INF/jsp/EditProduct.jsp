<%@page import="dao.CourseDAO"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
	<h3 class="title">Edit Course</h3>
	<a href="VendorHome" class="home">Home</a>
	<%
		String ccode = request.getParameter("ccode");
		Course c = CourseDAO.findCourse(ccode);
	%>
	<form style="width: 500px; margin: auto;" action="EditPro"
		method="post">
		<label class="label" for="ccode">Course Code</label> <input
			type="text" placeholder="Course Code" class="controls"
			style="background-color: lightgrey" value="<%=c.getCcode()%>"
			name="ccode" readonly id="ccode"><br> <label
			class="label" for="cname">Course Name</label> <input type="text"
			placeholder="Course Name" value="<%=c.getCname()%>"
			class="controls" name="cname" id="cname"><br> <label
			class="label" for="dur">Duration (Months)</label> <input
			type="number" placeholder="Duration in months"
			value="<%=c.getDuration()%>" class="controls" name="duration"
			id="dur"><br> <label class="label" for="amt">Course
			Fees</label> <input type="text" placeholder="Course Fees"
			value="<%=c.getAmount()%>" class="controls" name="amount" id="amt"><br>


		<input type="submit" class="btn" value="Update Product">
	</form>
	<%
		if (c.getActive().equals("Y")) {
	%>
	<a class="btn" style="background-color: red"
		href="CDeActivate?action=n&ccode=<%=c.getCcode()%>"
		onclick="return confirm('Are you sure you want to deactivate the course ?')">Deactivate
		Course</a>
	<%
		} else {
	%>
	<a class="btn" style="background-color: green"
		href="CDeActivate?action=y&ccode=<%=c.getCcode()%>">Activate
		Course</a>
	<% } %>
</body>
</html>