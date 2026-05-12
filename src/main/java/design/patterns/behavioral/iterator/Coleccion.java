package design.patterns.behavioral.iterator;

public interface Coleccion<T> {
    Iterador<T> crearIterador();
}
