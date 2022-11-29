package jspcomponentization.servlet.utils;

@FunctionalInterface
public interface IComponent {
	
	public String render();
	public default String render(IComponent... children) {
		return render();
	};
	
}
