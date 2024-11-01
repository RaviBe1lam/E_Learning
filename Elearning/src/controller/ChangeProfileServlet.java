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

@WebServlet("/UpdateProfile")
public class ChangeProfileServlet extends HttpServlet {
	
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
			String line1=req.getParameter("add1");
			String line2=req.getParameter("add2");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String pincode=req.getParameter("pincode");

			User user=new User();
			user.setName(name);
			user.setGender(gender);
			user.setEmail(email);			
			user.setPhone(phone);
			Address address=new Address();
			address.setLine1(line1);
			address.setLine2(line2);
			address.setCity(city);
			address.setState(state);
			address.setPincode(pincode);
			user.setAddress(address);
			
			HttpSession session=req.getSession();
			User u=(User)session.getAttribute("user");
			String redirect=u.getRole().equals("LNR")?"LearnerHome":"VendorHome";
			if(UserDAO.updateProfile(user)) {				
					session.setAttribute("success", "User Updated..");
					u.setName(name);
					u.setPhone(phone);
					u.setGender(gender);
					u.setAddress(address);
					
					session.setAttribute("user", u);
					resp.sendRedirect(redirect);				
			}else {
				session.setAttribute("error", "Updation failed.");
				resp.sendRedirect(redirect);
			}

		}catch(Exception ex) {
			resp.getWriter().println("Error "+ex.getMessage());
		}
	}
}
