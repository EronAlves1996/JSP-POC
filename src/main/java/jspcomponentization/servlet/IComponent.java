package jspcomponentization.servlet;

public interface IComponent {
	
	public String render();
	public String render(String... children);
	
}
