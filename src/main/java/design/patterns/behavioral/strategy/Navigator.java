package design.patterns.behavioral.strategy;

public class Navigator {
  RouteStrategy routeStrategy;

  public Navigator(RouteStrategy routeStrategy) {
    this.routeStrategy = routeStrategy;
  }

  public void setRouteStrategy(RouteStrategy routeStrategy) {
    this.routeStrategy = routeStrategy;
  }

  public String buildRoute(String A, String B) {
    return this.routeStrategy.buildRoute(A, B);
  }
}
