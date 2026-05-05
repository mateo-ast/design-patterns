package design.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Context/Bosque que utiliza los objetos Flyweight.
 * Esta clase mantiene el estado extrínseco (posiciones de los árboles)
 * y utiliza la factory para obtener los objetos Flyweight compartibles.
 */
public class Bosque {
    
    /**
     * Clase interna que representa un árbol en el bosque.
     * Almacena la referencia al Flyweight y el estado extrínseco (posición).
     */
    private static class ArbolEnBosque {
        private final Arbol flyweight;
        private final int x;
        private final int y;
        
        public ArbolEnBosque(Arbol flyweight, int x, int y) {
            this.flyweight = flyweight;
            this.x = x;
            this.y = y;
        }
        
        public void mostrar() {
            flyweight.mostrar(x, y);
        }
    }
    
    // Lista de árboles en el bosque (cada uno con su estado extrínseco)
    private final List<ArbolEnBosque> arboles = new ArrayList<>();
    
    /**
     * Añade un árbol al bosque.
     * 
     * @param tipo tipo de árbol
     * @param altura altura del árbol
     * @param color color del árbol
     * @param textura textura del árbol
     * @param x posición X
     * @param y posición Y
     */
    public void plantarArbol(String tipo, int altura, String color, String textura, int x, int y) {
        // Obtener el Flyweight del factory (nuevo o reutilizado)
        Arbol arbolFlyweight = ArbolFlyweightFactory.obtenerArbol(tipo, altura, color, textura);
        
        // Crear la entrada del bosque con el estado extrínseco
        arboles.add(new ArbolEnBosque(arbolFlyweight, x, y));
    }
    
    /**
     * Muestra todos los árboles del bosque.
     */
    public void mostrarBosque() {
        System.out.println("\nMostrando " + arboles.size() + " árboles del bosque:\n");
        for (int i = 0; i < arboles.size(); i++) {
            System.out.print("[" + (i + 1) + "] ");
            arboles.get(i).mostrar();
        }
    }
    
    /**
     * @return cantidad de árboles en el bosque
     */
    public int obtenerCantidadArboles() {
        return arboles.size();
    }
}
