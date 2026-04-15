package design.patterns.creational.abstractfactory.cliente;

import design.patterns.creational.abstractfactory.factoriaabstracta.UIFactory;
import design.patterns.creational.abstractfactory.productoabstracto.Pokemon;

public class Cliente {
    private Pokemon pokemon;
    
    public Cliente(UIFactory factory) {
        this.pokemon = factory.crearPokemon();
    }
    
    public void jugar() {
        pokemon.atacar();
    }
}
