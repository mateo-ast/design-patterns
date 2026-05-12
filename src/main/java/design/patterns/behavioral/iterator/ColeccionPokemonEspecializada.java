package design.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Colección especializada para Pokemon que implementa el patrón Colección
 * permitiendo crear diferentes tipos de iteradores
 */
public class ColeccionPokemonEspecializada implements Coleccion<Pokemon> {
    private List<Pokemon> pokemons = new ArrayList<>();

    public void agregar(Pokemon p) {
        pokemons.add(p);
    }

    public void eliminar(Pokemon p) {
        pokemons.remove(p);
    }

    public int longitud() {
        return pokemons.size();
    }

    public Pokemon obtener(int indice) {
        if (indice < 0 || indice >= pokemons.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return pokemons.get(indice);
    }

    /**
     * Crea un iterador normal que itera de principio a fin
     */
    @Override
    public Iterador<Pokemon> crearIterador() {
        return new IteradorLista<>(pokemons);
    }

    /**
     * Crea un iterador inverso que itera de fin a principio
     */
    public Iterador<Pokemon> crearIteradorInverso() {
        return new IteradorInverso(pokemons);
    }

    /**
     * Crea un iterador que solo itera Pokémon de un tipo específico
     */
    public Iterador<Pokemon> crearIteradorPorTipo(String tipo) {
        return new IteradorPorTipo(pokemons, tipo);
    }

    /**
     * Crea un iterador ordenado por número de Pokédex
     */
    public Iterador<Pokemon> crearIteradorOrdenado() {
        return new IteradorOrdenado(pokemons);
    }
}
