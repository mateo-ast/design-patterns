package design.patterns.behavioral.strategy;

import design.patterns.DesignPattern;

public class Strategy implements DesignPattern {
    @Override
    public void run() {
        System.out.println("Executing pattern: Strategy");
        Navigator navigator = new Navigator(new Road());
        System.out.println(navigator.buildRoute("España y Av. Mitre", "Bolivia y Salta"));
        navigator.setRouteStrategy(new Walking());
        System.out.println(navigator.buildRoute("España y Av. Mitre", "Bolivia y Salta"));
    }
}
