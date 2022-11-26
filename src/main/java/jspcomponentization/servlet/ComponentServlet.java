package jspcomponentization.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/component")
public class ComponentServlet extends HttpServlet {

	Map<String, String> components = new HashMap<>();

	@Override
	public void init() {
		components.put("shifting", "<p>This is the shifting component</p>" + "<h3>What is this shifting</h3>"
				+ "<p>Shifting component is just a generic component</p>");
		components.put("ouroboros",
				"<p>Ouruboros component</p>" + "<h3 style=\"color:green;\">Ouroboros component is awesome</h3>");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("component", components.get(request.getAttribute("callComponent")));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/templates/components.jsp");
		requestDispatcher.forward(request, response);
	}

}
