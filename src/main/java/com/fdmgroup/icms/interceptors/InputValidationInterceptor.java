package com.fdmgroup.icms.interceptors;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fdmgroup.icms.models.User;

public class InputValidationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		// TODO * Query Database *

		User user = new User();
		user.setUsername("username");
		user.setPassword("password");

		List<User> userList = new ArrayList<>();
		userList.add(user);

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();

		String patternString = "^[A-Za-z0-9]+[A-Za-z0-9._)(*&^%$#@!-+=]*";
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		Matcher usernameMatcher = pattern.matcher(username);
		Matcher passwordMatcher = pattern.matcher(password);

		
		if (username.equals("") || password.equals("")) {
			request.setAttribute("Error_Message", "All fields must be completed.");
			request.setAttribute("Display_Message", "block");

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/complaint/login.jsp");
			rd.forward(request, response);

			return false;

		} else if (!usernameMatcher.matches() || !passwordMatcher.matches()) {
			request.setAttribute("Error_Message", "Username and Password combination does not exist.");
			request.setAttribute("Display_Message", "block");

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/complaint/login.jsp");
			rd.forward(request, response);

			return false;
			
		} else {

			boolean userExists = false;
			for (User u : userList) {
				if (username.equals(u.getUsername())) {
					if (password.equals(u.getPassword())) {
						userExists = true;
					}
				}
			}

			if (!userExists) {
				request.setAttribute("Error_Message", "Username and Password combination does not exist.");
				request.setAttribute("Display_Message", "block");

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/complaint/login.jsp");
				rd.forward(request, response);

				return false;

			} else {
				return true;
			}
		}
	}

}
