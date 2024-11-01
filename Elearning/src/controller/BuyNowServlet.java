package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import dao.OrderDAO;
import dao.UserDAO;
import model.Address;
import model.Course;
import model.Order;
import model.User;

@WebServlet("/BuyNow")
public class BuyNowServlet extends HttpServlet {
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
			String ccode=req.getParameter("ccode");			
			User user=(User)session.getAttribute("user");
			String userid=user.getEmail();

			Order order=new Order();
			order.setUserid(userid);
			order.setCcode(ccode);
			
			OrderDAO.saveOrder(order);

			session.setAttribute("success", "Order Confirmed..");
			resp.sendRedirect("PHistory");
			
		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
}
