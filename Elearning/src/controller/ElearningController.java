package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class ElearningController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
//		resp.getWriter().println("path "+req.getRequestURI());
//		resp.getWriter().println("path "+req.getRequestURL());		
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp")
		.forward(req, resp);
	}
}
