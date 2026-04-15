package design.patterns.behavioral.strategy;

public class Walking implements RouteStrategy {

	@Override
	public String buildRoute(String A, String B) {
	  return "Ruta caminando desde " + A + " hasta " + B;
	}
}
