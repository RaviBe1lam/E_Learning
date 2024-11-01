package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import dao.UserDAO;
import model.User;

@WebServlet("/CDeActivate")
public class DeActivateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session=req.getSession();
			String ccode=req.getParameter("ccode");
			String action=req.getParameter("action");
			CourseDAO.deactivate(ccode,action);
			session.setAttribute("error", "Course Deactivated..");
			resp.sendRedirect("Products");			
		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
	
}
