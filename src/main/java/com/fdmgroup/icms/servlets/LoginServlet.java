package com.fdmgroup.icms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5612985492182927103L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		RequestDispatcher rd = req.getRequestDispatcher("./WEB-INF/complaint/issues.jsp");
		rd.forward(req, resp);
	}

}

