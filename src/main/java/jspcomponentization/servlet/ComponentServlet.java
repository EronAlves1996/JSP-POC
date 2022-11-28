package jspcomponentization.servlet;

import java.io.IOException;
import java.util.Arrays;
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
	
	private Map<String, IComponent> components = new HashMap<>();
	
	private void addComponent(String name, IComponent component) {
		components.put(name, component);
	}
	
	@Override
	public void init() {
		addComponent("shifting", ()->"<p>This is the shifting component</p>" + "<h3>What is this shifting</h3>"
		+ "<p>Shifting component is just a generic component</p>");
		addComponent("ouroboros", ()->"<p>Ouruboros component</p>" + "<h3 style=\"color:green;\">Ouroboros component is awesome</h3>");
		addComponent("test", new IComponent() {
			@Override
			public String render() {
				return "<h3> Test component </h3>";
			}
			@Override
			public String render(IComponent... children) {
				StringBuilder formatted = new StringBuilder().append("<div> <h3>Formatted </h3>");
				Arrays.stream(children).forEach(c -> formatted.append(c.render()));
				formatted.append("</div>");
				return formatted.toString();
			}
		});
		addComponent("oneTest", ()->components.get("test").render(()->"<p>With new element</p>"));
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("component", components.get(request.getAttribute("component")).render());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/templates/components.jsp");
		requestDispatcher.forward(request, response);
	}

}
