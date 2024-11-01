<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<jsp:include page="header.jsp" flush="true"/>

<h3 class="title">Modify User Details</h3>
	<a class="btn" href="AdminHome">Home</a>

<%
String userid=request.getParameter("userid");
User user=UserDAO.findUser(userid);
%>
<form style="text-align:left;width:500px;margin:auto;" method="post" action="UpdateInfo">
	<label class="label" for="name">Name</label>
	<input type="text" class="controls" name="name" id="name" value="<%= user.getName() %>"><br>
	
	<label class="label" for="name">Email ID</label>
	<input type="email" class="controls" name="email" readonly style="background-color:lightgrey" id="email" value="<%= user.getEmail() %>"><br>
	
	<label class="label" for="phone">Phone</label>
	<input type="text" class="controls" name="phone" id="phone" value="<%= user.getPhone() %>"><br>
	
	<label class="label">Gender</label>
	<input type="radio" name="gender" id="male" value="male" <%= user.getGender().equals("male")?"checked":"" %>>
	<label for="male">Male</label>
	<input type="radio" name="gender" id="female" value="female" <%= user.getGender().equals("female")?"checked":"" %>>
	<label for="female">Female</label><br><br>
	
	<label class="label">Role</label>
	<input type="radio" name="role" id="learner" value="LNR" <%= user.getRole().equals("LNR")?"checked":"" %> >
	<label for="learner">Learner</label>
	<input type="radio" name="role" id="vendor" value="VND" <%= user.getRole().equals("VND")?"checked":"" %> >
	<label for="vendor">Vendor</label><br><br>
	
	<label class="label">Active Status</label>
	<input type="radio" name="active" id="y" value="Y" <%= user.getActive().equals("Y")?"checked":"" %>>
	<label for="y">Activate</label>
	<input type="radio" name="active" id="n" value="N" <%= user.getActive().equals("N")?"checked":"" %>>
	<label for="n">Deactivate</label><br><br>
	
	<input class="btn" style="margin:auto;display:block" type="submit" value="Update Info">
</form>
<jsp:include page="footer.jsp" flush="true"/>
