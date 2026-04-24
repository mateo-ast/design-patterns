package design.patterns.structural.decorator;

import design.patterns.DesignPattern;

public class Decorator implements DesignPattern {
    @Override
    public void run() {
        Component componente = new ConcreteComponent();            //Crea el objeto base.
        Component decorado = new ConcreteDecoratorA(componente);        //Envuelve el componente con un decorador.

        System.out.println("Executing pattern: Decorator");
        System.out.println(componente.operation());
        System.out.println(decorado.operation());
    }
}
