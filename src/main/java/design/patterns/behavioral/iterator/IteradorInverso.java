package design.patterns.behavioral.iterator;

import java.util.List;

/**
 * Iterador que recorre la colección en orden inverso (de fin a principio)
 */
public class IteradorInverso implements Iterador<Pokemon> {
    private List<Pokemon> elementos;
    private int posicion;

    public IteradorInverso(List<Pokemon> elementos) {
        this.elementos = elementos;
        this.posicion = elementos.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return posicion >= 0;
    }

    @Override
    public Pokemon next() {
        if (!hasNext()) {
            throw new IllegalStateException("No hay más elementos");
        }
        return elementos.get(posicion--);
    }

    @Override
    public void reset() {
        posicion = elementos.size() - 1;
    }
}
