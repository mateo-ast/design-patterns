package design.patterns.behavioral.strategy;

public class Road implements RouteStrategy {
    public Road() {
        
    }

    @Override
    public String buildRoute(String A, String B) {
    	  return "Ruta en auto desde " + A + " hasta " + B;
    }
}
