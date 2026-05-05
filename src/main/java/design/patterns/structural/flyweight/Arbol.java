package design.patterns.structural.flyweight;

/**
 * Interfaz Flyweight que define el contrato para objetos compartibles.
 * Los métodos reciben el estado extrínseco (posición) como parámetro.
 */
public interface Arbol {
    /**
     * Muestra el árbol en una posición específica (estado extrínseco).
     * 
     * @param x posición en eje X
     * @param y posición en eje Y
     */
    void mostrar(int x, int y);
    
    /**
     * @return el tipo de árbol (estado intrínseco)
     */
    String getTipo();
}
