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

@WebServlet("/Validate")
public class ValidateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userid=req.getParameter("userid");
			String pwd=req.getParameter("pwd");
			String role=req.getParameter("role");

			HttpSession session=req.getSession();
			User user=UserDAO.validate(userid, pwd, role);

			if(user==null) {
				session.setAttribute("error", "Invalid username or password..");
				resp.sendRedirect("home");
			}
			else if(user.getActive().equals("N")){
				session.setAttribute("error", "Account deactivated..");
				resp.sendRedirect("home");
			}
			else if(user.getRole().equals("ADM")){
				session.setAttribute("user", user);
				resp.sendRedirect("AdminHome");
			}else if(user.getRole().equals("LNR")) {
				session.setAttribute("user", user);
				resp.sendRedirect("LearnerHome");
			}else if(user.getRole().equals("VND")) {
				session.setAttribute("user", user);
				resp.sendRedirect("VendorHome");
			}

		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
}
