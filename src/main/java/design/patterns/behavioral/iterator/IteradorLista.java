package design.patterns.behavioral.iterator;
import java.util.List;

public class IteradorLista<T> implements Iterador<T>{
    private List<T> elementos;
    private int posicion = 0;
    public IteradorLista(List<T> elementos) {
        this.elementos = elementos;
    }    

    @Override
    public boolean hasNext() {
        return posicion < elementos.size(); 
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No hay más elementos");
        }
        return elementos.get(posicion++);
    }

    @Override
    public void reset() {
        posicion = 0;
    }

}
