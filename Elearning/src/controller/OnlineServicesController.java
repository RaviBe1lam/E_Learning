package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/OnlineCourses")
public class OnlineServicesController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null && user.getRole().equals("LNR")) {
			req.getRequestDispatcher("/WEB-INF/jsp/OnlineServices.jsp")
			.forward(req, resp);
		}else {
			session.setAttribute("error", "Please login first");
			resp.sendRedirect("home");
		}
		
						
	}
}
