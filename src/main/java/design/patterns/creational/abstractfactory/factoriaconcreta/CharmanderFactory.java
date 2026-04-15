package design.patterns.creational.abstractfactory.factoriaconcreta;

import design.patterns.creational.abstractfactory.factoriaabstracta.UIFactory;
import design.patterns.creational.abstractfactory.productoabstracto.Pokemon;
import design.patterns.creational.abstractfactory.productoconcreto.Charmander;

public class CharmanderFactory implements UIFactory {
    @Override
    public Pokemon crearPokemon() {
        return new Charmander();
    }
    
}
