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

@WebServlet("/UpdateInfo")
public class ChangeInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {			
			String name=req.getParameter("name");
			String gender=req.getParameter("gender");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			String role=req.getParameter("role");
			String active=req.getParameter("active");

			User user=new User();
			user.setName(name);
			user.setGender(gender);
			user.setEmail(email);
			user.setActive(active);
			user.setPhone(phone);
			user.setRole(role);
			
			HttpSession session=req.getSession();
			if(UserDAO.changeUser(user)) {				
					session.setAttribute("success", "User Updated..");
					resp.sendRedirect("AdminHome");				
			}else {
				session.setAttribute("error", "Updation failed.");
				resp.sendRedirect("AdminHome");
			}

		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
}
