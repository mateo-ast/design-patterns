package design.patterns.creational.abstractfactory.productoconcreto;

import design.patterns.creational.abstractfactory.productoabstracto.Pokemon;

public class Charmander implements Pokemon {
    @Override
    public void atacar() {
        System.out.println("Charmander usa Llamarada!");
    }
    
}
