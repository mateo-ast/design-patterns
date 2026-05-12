package design.patterns.behavioral.iterator;
import java.util.ArrayList;
import java.util.List;
public class ColeccionPokemon<T> implements Coleccion<T> {
    private List<T> pokemon = new ArrayList<>();
    public void agregar(T p) {
        pokemon.add(p);
    }
    public void eliminar(T p) {
        pokemon.remove(p);
    }
    public int longitud() {
        return pokemon.size();
    }
    @Override
    public Iterador<T> crearIterador() {
        return new IteradorLista<>(pokemon);
    }
    
}
