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
import model.Address;
import model.Course;
import model.User;

@WebServlet("/EditPro")
public class EditProductServlet extends HttpServlet {
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
			String cname=req.getParameter("cname");
			String ccode=req.getParameter("ccode");
			int duration=Integer.parseInt(req.getParameter("duration"));
			int amount=Integer.parseInt(req.getParameter("amount"));			
			
			Course c=new Course();
			c.setCcode(ccode);
			c.setCname(cname);
			c.setDuration(duration);
			c.setAmount(amount);
			CourseDAO.changeCourse(c);
			
			session.setAttribute("success", "Product updated..");
			resp.sendRedirect("Products");
			
		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
}
