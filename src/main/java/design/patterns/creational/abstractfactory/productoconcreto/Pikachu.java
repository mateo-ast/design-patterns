package design.patterns.creational.abstractfactory.productoconcreto;

import design.patterns.creational.abstractfactory.productoabstracto.Pokemon;

public class Pikachu implements Pokemon {
    @Override
    public void atacar() {
        System.out.println("Pikachu usa Impactrueno!");
    }
    
}
