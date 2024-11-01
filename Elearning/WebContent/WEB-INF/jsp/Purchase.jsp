<%@page import="dao.CourseDAO"%>
<%@page import="model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="css/elearning.css">
<h3 class="title">Purchase Online Course</h3>
<a href="VendorHome" class="home">Home</a>
	<%
		String ccode = request.getParameter("ccode");
		Course c = CourseDAO.findCourse(ccode);
	%>
	<form style="width: 500px; margin: auto;" action="BuyNow"
		method="post">
		<label class="label" for="ccode">Course Code</label> 
		<input
			type="text" placeholder="Course Code" class="controls"
			style="background-color: lightgrey" readonly value="<%=c.getCcode()%>"
			name="ccode"  id="ccode"><br> 
			<label
			class="label" for="cname">Course Name</label> 
			<input type="text"
			style="background-color: lightgrey" readonly 
			placeholder="Course Name" value="<%=c.getCname()%>"
			class="controls" name="cname" id="cname"><br> 
			
			<label class="label" for="amt">Course
			Fees</label> <input type="text"
			style="background-color: lightgrey" readonly  
			placeholder="Course Fees"
			value="<%=c.getAmount()%>" class="controls" name="amount" id="amt"><br>

			
		<input type="submit" class="btn" value="Buy Now">
	</form>
</body>
</html>