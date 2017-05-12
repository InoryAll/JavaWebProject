package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Person;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		HttpSession session = request.getSession();
		Person loginUser = (Person) session.getAttribute("loginUser");
		String action = request.getParameter("action");
		String URL = request.getRequestURI();
		String [] temp = URL.split("user/");
		if((action != null && action.equals("login"))) chain.doFilter(req, rsp);
		else if(loginUser != null) chain.doFilter(req, rsp);
		else if(temp.length == 2 &&temp[1].equals("login.jsp")) chain.doFilter(req, rsp);
		else {
			request.setAttribute("Message", "请登录后再操作");
			response.sendRedirect("../user/login.jsp");
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
