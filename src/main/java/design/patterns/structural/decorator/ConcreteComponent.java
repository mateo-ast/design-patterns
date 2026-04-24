package design.patterns.structural.decorator;

public class ConcreteComponent implements Component {
    @Override           //Indica que estás sobrescribiendo el método de la interfaz.
    public String operation() {
        return "Existe el componente base";           //comportamiento base.
    }
}
