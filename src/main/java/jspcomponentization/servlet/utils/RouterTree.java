package jspcomponentization.servlet.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouterTree {
    
    private IComponent mainComponent;
    private Map<String, RouterTree> childrenComponent = new HashMap<>();
    
    public RouterTree(IComponent component) {
        mainComponent = component;
    }
    
    public RouterTree() {}
    
    public void addRoute(String route, IComponent component) {
        List<String> routes = Arrays.asList(route.split("/"));
        if(routes.size() == 1) childrenComponent.put(route, new RouterTree(component));
        else addRoute(routes, component);
    }
    
     void addRoute(List<String> route, IComponent component) {
        if(route.size() == 1) {
            addRoute(route.get(0), component);
            return;
        }
        
        String componentRoute = route.get(0); 
        
        if(childrenComponent.containsKey(componentRoute)){
            childrenComponent.get(componentRoute).addRoute(route.subList(1, route.size()), component);
        } else {
            childrenComponent.put(route.get(0), new RouterTree());
            childrenComponent.get(componentRoute).addRoute(route.subList(1, route.size()), component);
        }
    }
    
    public IComponent getComponentOnRoute(String route) {
        if(route == "") {
            return mainComponent;
        }   
        List<String> routes = Arrays.asList(route.split("/"));
        return getComponentOnRoute(routes);
    }
    
    public IComponent getComponentOnRoute(List<String> route) {
        if(route == null || route.size() == 0) return getComponentOnRoute("");
        return childrenComponent.get(route.get(0)).getComponentOnRoute(route.subList(1, route.size()));
    }
}
