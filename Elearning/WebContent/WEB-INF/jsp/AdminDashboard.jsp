<%@page import="java.util.List"%>
<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<html><body> 

<jsp:include page="header.jsp" flush="true"/>
<h1 class="title">Admin Dashboard</h1>

<%
User user=(User)session.getAttribute("user");
%>

<h2>Welcome <%=  user.getName() %></h2>

<%
String role=request.getParameter("role");
List<User> list=UserDAO.getUsers(role);
if(list.size()==0) { %>
	<h4 style="color:red">No User Exists</h4>
<%
}else{
	%>
	
	<a class="btn" href="CreateUser">Create User</a>
	<a class="btn" href="AllProducts">All Courses</a>
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
			<th>User Name</th>
			<th>Email ID</th>
			<th>Gender</th>
			<th>Contact No</th>
			<th>Role</th>
			<th>Active</th>
			<th>Action</th>
		</tr>
		<% for(User u : list){ %>
		<tr>
		<td><%= u.getName() %></td>
		<td><%= u.getEmail() %></td>
		<td><%= u.getGender() %></td>
		<td><%= u.getPhone() %></td>
		<td><%= u.getRole() %></td>
		<td><%= u.getActive() %></td>
		<td><a class="btn" style="margin:0;" href="ChangeUser?userid=<%= u.getEmail() %>">Modify</a></td>
		</tr>
		<% } %>
	</table>
	<%
}
%>

<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>
