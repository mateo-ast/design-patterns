package design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Una Carpeta es un elemento COMPUESTO: puede contener
// archivos Y otras carpetas. Esto es el corazón del patrón.
// En términos del patrón, esto se llama "Composite"
public class Carpeta implements Componente {

    // El nombre de la carpeta, por ejemplo "Fotos"
    private String nombre;

    // Lista de hijos: pueden ser Archivos u otras Carpetas.
    // Como ambos implementan Componente, los guardamos así.
    private List<Componente> hijos = new ArrayList<>();

    // Constructor: le damos el nombre a la carpeta
    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar un hijo (archivo o carpeta)
    public void agregar(Componente componente) {
        hijos.add(componente);
    }

    // Método para quitar un hijo
    public void quitar(Componente componente) {
        hijos.remove(componente);
    }

    // Implementamos el método de la interfaz.
    // Primero muestra la carpeta, luego recorre todos sus hijos
    @Override
    public void mostrar(int nivel) {
        // Imprime el nombre de la carpeta con sangría
        System.out.println("  ".repeat(nivel) + "📁 " + nombre);

        // Recorre cada hijo y le pide que se muestre también,
        // pero con un nivel más de profundidad (nivel + 1)
        // Esto hace que los hijos aparezcan más adentro
        for (Componente hijo : hijos) {
            hijo.mostrar(nivel + 1);
        }
    }
}