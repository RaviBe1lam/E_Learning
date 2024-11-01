package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.Address;
import model.User;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		try {
			String line1=req.getParameter("add1");
			String line2=req.getParameter("add2");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String country=req.getParameter("country");
			String pincode=req.getParameter("pincode");

			Address address=new Address(line1, line2, city, state, country, pincode);
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			String gender=req.getParameter("gender");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			String pwd=req.getParameter("pwd");
			String role=req.getParameter("role");

			User user=new User(name, age, phone, gender, pwd, address, role, email);
			
			if(UserDAO.checkavail(email)) {
				if(UserDAO.addUser(user)) {
					session.setAttribute("success", "User registered..");
					if(session.getAttribute("user")==null) {
						resp.sendRedirect("SignUp");
					}else {
						resp.sendRedirect("AdminHome");
					}
				}else {
					session.setAttribute("error", "Registeration failed..");
					if(session.getAttribute("user")==null) {
						resp.sendRedirect("SignUp");
					}else {
						resp.sendRedirect("AdminHome");
					}
				}
			}else {
				session.setAttribute("error", "User already exists..");
				if(session.getAttribute("user")==null) {
					resp.sendRedirect("SignUp");
				}else {
					resp.sendRedirect("AdminHome");
				}
			}

		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
}
