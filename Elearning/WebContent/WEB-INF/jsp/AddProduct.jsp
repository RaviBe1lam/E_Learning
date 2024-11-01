<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elearning Management</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
<h3 class="title">Add New Courses</h3>
<a href="AdminHome" class="home">Home</a>
<form style="width:500px;margin:auto;" action="AddPro" method="post">
	<label class="label" for="ccode">Course Code</label>
	<input type="text" placeholder="Course Code"
	class="controls" name="ccode" id="ccode" required title="Min 4 and Max 50 characters"><br>
	
	<label class="label" for="cname">Course Name</label>
	<input type="text" placeholder="Course Name"
	class="controls" name="cname" id="cname" required title="Min 4 and Max 50 characters"><br>
	
	<label class="label" for="dur">Duration (Months)</label>
	<input type="number" placeholder="Duration in months"
	class="controls" name="duration" id="dur"required title="enter month"><br>
	
	<label class="label" for="amt">Course Fees</label>
	<input type="text" placeholder="Course Fees"
	class="controls" name="amount" id="amt" required title="enter the amount" ><br>
	
	<input type="submit" class="btn" value="Add Product">
</form>
</body>
</html>