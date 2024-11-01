<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body>
<a href="LearnerHome" class="home">Home</a>
<h1 class="title">Learner Profile</h1>

<%
User user=(User)session.getAttribute("user");
%>
<form style="text-align:left;width:500px;margin:auto;" 
method="post" action="UpdateProfile">
	<label class="label" for="name">Name</label>
	<input type="text" pattern="[A-Za-z ]{4,50}" required
			title="Min 4 and Max 50 characters" class="controls" name="name" readonly style="background-color:lightgrey" id="name" value="<%= user.getName() %>"><br>
	
	<label class="label" for="name">Email ID</label>
	<input type="email" class="controls" name="email" readonly style="background-color:lightgrey" id="email" value="<%= user.getEmail() %>"><br>
	
	<label class="label" for="phone">Phone</label>
	<input type="text" class="controls" maxlength="10" name="phone" id="phone" placeholder="Contact Number"
			pattern="[7-9]{1}[0-9]{9}" value="<%= user.getPhone() %>"><br>
	
	<label class="label">Gender</label>
	<input type="radio" name="gender" id="male" value="male" <%= user.getGender().equals("male")?"checked":"" %>>
	<label for="male">Male</label>
	<input type="radio" name="gender" id="female" value="female" <%= user.getGender().equals("female")?"checked":"" %>>
	<label for="female">Female</label><br><br>
	<label class="label" for="add1">Address Line 1</label>
	<input type="text" class="controls" name="add1" id="add1" required value="<%= user.getAddress().getLine1() %>" required /><br>
	
	<label class="label" for="add2">Address Line 2</label>
	<input type="text" class="controls" name="add2" id="add2" required value="<%= user.getAddress().getLine1() %>" required /><br>
	
	<label class="label" for="city">City</label>
	<input type="text" class="controls" name="city" id="city" value="<%= user.getAddress().getCity() %>" required /><br>
	
	<label class="label" for="state">State</label>
	<input type="text" class="controls" name="state" id="state" value="<%= user.getAddress().getState() %>" required /><br>
	
	<label class="label" for="state">Pincode</label>
	<input type="text" class="controls" name="pincode" id="pincode" pattern="[0-9]{6,6}" title="pincode should be only six charecters" value="<%= user.getAddress().getPincode() %>" required /><br>
	
	
	<input class="btn" style="margin:auto;display:block" type="submit" value="Update Info">
</form>
<a class="btn" style="margin:10px;background-color:red" 
href="DeActivate" onclick="return confirm('Are you sure you want to deactivate the account ?')">Deactivate Account</a>
</body>
</html>