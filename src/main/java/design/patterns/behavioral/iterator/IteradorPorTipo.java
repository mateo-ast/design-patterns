package design.patterns.behavioral.iterator;

import java.util.List;

/**
 * Iterador que solo itera sobre Pokémon de un tipo elemental específico
 */
public class IteradorPorTipo implements Iterador<Pokemon> {
    private List<Pokemon> elementos;
    private String tipoFiltro;
    private int posicion = 0;

    public IteradorPorTipo(List<Pokemon> elementos, String tipoFiltro) {
        this.elementos = elementos;
        this.tipoFiltro = tipoFiltro;
        this.posicion = 0;
    }

    /**
     * Verifica si un Pokémon tiene el tipo buscado (tipo1 o tipo2)
     */
    private boolean tieneTipo(Pokemon pokemon) {
        String tipos = pokemon.getTipos();
        return tipos.contains(tipoFiltro);
    }

    /**
     * Busca el siguiente Pokémon con el tipo deseado
     */
    private Pokemon obtenerProximo() {
        while (posicion < elementos.size()) {
            Pokemon pokemon = elementos.get(posicion);
            if (tieneTipo(pokemon)) {
                return pokemon;
            }
            posicion++;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        // Verificamos si hay un siguiente Pokémon del tipo buscado
        int posicionTemp = posicion;
        while (posicionTemp < elementos.size()) {
            if (tieneTipo(elementos.get(posicionTemp))) {
                return true;
            }
            posicionTemp++;
        }
        return false;
    }

    @Override
    public Pokemon next() {
        Pokemon pokemon = obtenerProximo();
        if (pokemon == null) {
            throw new IllegalStateException("No hay más Pokémon del tipo: " + tipoFiltro);
        }
        posicion++;
        return pokemon;
    }

    @Override
    public void reset() {
        posicion = 0;
    }
}
