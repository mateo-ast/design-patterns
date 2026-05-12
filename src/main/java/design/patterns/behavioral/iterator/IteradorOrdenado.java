package design.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterador que recorre la colección ordenada por número de Pokédex
 */
public class IteradorOrdenado implements Iterador<Pokemon> {
    private List<Pokemon> elementosOrdenados;
    private int posicion = 0;

    public IteradorOrdenado(List<Pokemon> elementos) {
        // Creamos una copia y la ordenamos por número de Pokédex
        this.elementosOrdenados = new ArrayList<>(elementos);
        this.elementosOrdenados.sort((p1, p2) -> 
            Integer.compare(p1.getnPokedex(), p2.getnPokedex())
        );
    }

    @Override
    public boolean hasNext() {
        return posicion < elementosOrdenados.size();
    }

    @Override
    public Pokemon next() {
        if (!hasNext()) {
            throw new IllegalStateException("No hay más elementos");
        }
        return elementosOrdenados.get(posicion++);
    }

    @Override
    public void reset() {
        posicion = 0;
    }
}
