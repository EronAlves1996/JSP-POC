package jspcomponentization.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspcomponentization.servlet.utils.IComponent;
import jspcomponentization.servlet.utils.RouterTree;


@WebServlet("/component")
public class ComponentServlet extends HttpServlet {
	
	private RouterTree routerTree = new RouterTree(()->"<h2>Main Component</h2>");
	
	@Override
	public void init() {
	    routerTree.addRoute("shifting", ()->"<h2>Shifting</h2>");
	    routerTree.addRoute("shifting/nested", ()->"<h2>Shifting and nested</h2>");
	    routerTree.addRoute("nested/any", ()->"Nested and any");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<String> routes = (List<String>) request.getAttribute("route");
		request.setAttribute("component", routerTree.getComponentOnRoute(routes).render());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/templates/components.jsp");
		requestDispatcher.forward(request, response);
	}

}
