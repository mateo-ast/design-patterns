package design.patterns.creational.abstractfactory.factoriaconcreta;

import design.patterns.creational.abstractfactory.factoriaabstracta.UIFactory;
import design.patterns.creational.abstractfactory.productoabstracto.Pokemon;
import design.patterns.creational.abstractfactory.productoconcreto.Pikachu;

public class PikachuFactory implements UIFactory {
    @Override
    public Pokemon crearPokemon() {
        return new Pikachu();
    }

    
    
}
