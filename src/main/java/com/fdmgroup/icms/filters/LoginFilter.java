package com.fdmgroup.icms.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.icms.classes.User;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		User user = new User();
		user.setUsername("username");
		user.setPassword("password");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		
		boolean userExists = false;
		
		for(User u : userList) {
			if(username.equals(u.getUsername())) {
				if(password.equals(u.getPassword())) {
					userExists = true;
				}
			}
		}
		
		if(!userExists) {
			
			request.setAttribute("Error_Message", "Username And Password Combination Does Not Exist");
			request.setAttribute("Display_Message", "block");
			
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			
			httpResponse.sendRedirect(httpResponse.encodeRedirectURL(httpRequest.getContextPath() + "/"));
			
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
