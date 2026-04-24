package design.patterns.structural.decorator;

//Clase abstracta. Un decorador es un componente también.
public abstract class DecoratorBase implements Component {
    protected Component wrappedComponent;       //Guarda una referencia al componente que está “envolviendo”.

    public DecoratorBase(Component component) {
        this.wrappedComponent = component;
    }

    @Override
    public String operation() {
        return wrappedComponent.operation();            //delega la llamada al componente envuelto.
    }
}
