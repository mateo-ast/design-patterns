package design.patterns.structural.decorator;

public class ConcreteDecoratorA extends DecoratorBase {
    public ConcreteDecoratorA(Component component) {
        super(component);       //Constructor que llama al constructor del padre.
    }

    @Override
    public String operation() {
        return super.operation() + " + decorador A";        //Sobrescribe el método.
    }
}
