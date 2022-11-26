package jspcomponentization.servlet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Component {
	String name() default "";
}
