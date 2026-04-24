package design.patterns.structural.decorator;


//patrón: extender comportamiento sin modificar la clase original.


public class DecoratorDemo {
    public static void main(String[] args) {
        Component componente = new ConcreteComponent();
        Component decorado = new ConcreteDecoratorA(componente);

        System.out.println(componente.operation());
        System.out.println(decorado.operation());
    }
}
