<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="css/elearning.css">
</head>
<body style="background-image:url('images/Photo3.jpg');   background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;">
  
<h4 class="title">E Learning management</h4>
	<h4 class="title">Welcome to Sign Up Page</h4>
		<a href="home" class="btn" style="float:right">Login</a>
	
	<form style="width:500px;margin:auto;" action="Register" method="post">
	
	<fieldset style="padding:10px;margin:10px;">
		<legend style="text-align:center">Personal Information</legend>
		
		<label class="label" for="name">User Name</label> 
		<input class="controls" id="name" 
		name="name" placeholder="Full Name"
			type="text" pattern="[A-Za-z ]{4,50}" required
			title="Min 4 and Max 50 characters"><br> 
			
			
		<label class="label" for="age">Age</label> 
		<input class="controls" placeholder="Age" 
		id="age" min="18" required name="age"
			type="number"><br> 
		<label class="label" for="phone">Contact
			Number</label> 
			<input class="controls" id="phone" maxlength="10" name="phone" 
			type="text" placeholder="Contact Number"
			pattern="[7-9]{1}[0-9]{9}"><br> 
			
		<label>Gender</label> <input
			type="radio" value="male" id="male" name="gender"> <label
			for="male">Male</label> <input type="radio" value="female"
			id="female" name="gender"> <label for="female">Female</label><br>
			
	</fieldset>

		
		<fieldset style="padding:10px;margin:10px;">
		<legend style="text-align:center">Address Information</legend>
		<input type="text"
			placeholder="Address Line 1" class="controls" name="add1" required /> <input
			type="text" class="controls" placeholder="Address Line2" name="add2" required /><br>
		<input type="text" class="controls" placeholder="City" name="city" required /> <input
			type="text" class="controls" placeholder="State" name="state" required /><br> <input
			type="text" class="controls" placeholder="Country" name="country" required /> <input
			type="text" class="controls" maxlength="6" placeholder="Pincode" name="pincode"
			pattern="[0-9]{6,6}" class="controls" title="pincode should be only six charecters"
			required /><br> 
			
			</fieldset>
			
			<fieldset style="padding:10px;margin:10px;">
		<legend style="text-align:center">Professional Information</legend>
		
			<label class="label" for="email">Email ID</label> 
		<input class="controls" id="email" name="email"
		placeholder="Email ID"
			type="email" required><br> 
		
		
		<label class="label" for="pwd">Password</label> <input id="pwd" required
		placeholder="Password"
			pattern="[A-Za-z]{4,50}" class="controls" name="pwd" type="password"><br>
		
			<label class="label">Select Role</label> <input type="radio"
			name="role" value="LNR"> <label>Learner</label> <input
			type="radio" name="role" value="VND"> <label>Vendor</label>
			</fieldset>

		<input class="btn" type="submit" value="Register">
	</form>
	<%
	if(session.getAttribute("success")!=null){
		%>
		<div class="success"><%= session.getAttribute("success") %></div>
		<%
		session.removeAttribute("success");
	}
	%>
	<%
	if(session.getAttribute("error")!=null){
		%>
		<div class="error"><%= session.getAttribute("error") %></div>
		<%
		session.removeAttribute("error");
	}
	%>
	<h3 style="color:red;">Already registered click
	<a class="link" href="home">here for login page</a></h3>
</body>
</html>