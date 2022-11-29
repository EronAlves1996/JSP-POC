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
        childrenComponent.put(route, new RouterTree(component));
    }
    
    public void addRoute(List<String> route, IComponent component) {
        if(route.size() == 1) {
            addRoute(route.get(0), component);
            return;
        }
        
        String componentRoute = route.get(0); 
        
        if(childrenComponent.containsKey(componentRoute)){
            childrenComponent.get(route.remove(0)).addRoute(route, component);
        } else {
            childrenComponent.put(route.remove(0), new RouterTree());
            childrenComponent.get(componentRoute).addRoute(route, component);
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
        if(route.size() == 0) return getComponentOnRoute("");
        return childrenComponent.get(route.remove(0)).getComponentOnRoute(route);
    }
}
