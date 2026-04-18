package design.patterns.structural.composite;

// Un Archivo es un elemento SIMPLE: no contiene nada adentro.
// En términos del patrón, esto se llama "Hoja" (Leaf)
public class Archivo implements Componente {

    // El nombre del archivo, por ejemplo "foto.jpg"
    private String nombre;

    // Constructor: cuando creamos un archivo le damos su nombre
    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    // Implementamos el método de la interfaz.
    // Solo imprime el nombre del archivo con sangría
    @Override
    public void mostrar(int nivel) {
        // Creamos espacios según el nivel de profundidad.
        // "  ".repeat(nivel) repite dos espacios 'nivel' veces.
        // Si nivel=2, los espacios son "    " (4 espacios)
        System.out.println("  ".repeat(nivel) + "📄 " + nombre);
    }
}