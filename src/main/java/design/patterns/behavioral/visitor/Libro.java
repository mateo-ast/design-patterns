package design.patterns.behavioral.visitor;
// Libro es un tipo de producto de la tienda.
// Implementa la interfaz Producto, por lo tanto DEBE tener aceptar().

public class Libro implements Producto {

    // El nombre del libro — atributo privado (encapsulamiento)
    private String titulo;

    // El precio del libro
    private double precio;

    // Constructor: cuando creamos un Libro, le pasamos título y precio
    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    // Getter para obtener el título desde afuera
    public String getTitulo() {
        return titulo;
    }

    // Getter para obtener el precio desde afuera
    public double getPrecio() {
        return precio;
    }

    // Este es el método clave del patrón Visitor.
    // El libro le dice al visitante: "visitame A MÍ, que soy un Libro".
    // Llama específicamente a visitarLibro(), no a visitarAlimento().
    // Esto se llama "double dispatch" — el comportamiento depende de
    // QUIÉN visita Y A QUIÉN visita.
    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarLibro(this); // "this" = yo mismo, este objeto Libro
    }
}