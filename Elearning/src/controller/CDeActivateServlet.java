package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/DeActivate")
public class CDeActivateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session=req.getSession();
			User user=(User)session.getAttribute("user");
			UserDAO.deActivate(user.getEmail());
			session.setAttribute("error", "Account Deactivated..");
			resp.sendRedirect("home");			
		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
	
}
