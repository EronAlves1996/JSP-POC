package jspcomponentization.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="componentDefiner", urlPatterns= {"/*"})
public class ServletFilter extends HttpFilter { 	

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		String[] splitted = request.getRequestURI().split("/");
		request.setAttribute("callComponent", splitted[splitted.length-1]);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/component");
		requestDispatcher.forward(request, response);
	}
}
