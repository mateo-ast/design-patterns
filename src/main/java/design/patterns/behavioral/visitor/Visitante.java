// El visitante es quien realiza las operaciones sobre los productos.
// Define un método distinto para CADA tipo de producto.
// Así puede comportarse diferente según a quién visita.
public interface Visitante {

    // Método para cuando visita un libro
    void visitarLibro(Libro libro);

    // Método para cuando visita un electrodoméstico
    void visitarElectrodomestico(Electrodomestico electrodomestico);

    // Método para cuando visita un alimento
    void visitarAlimento(Alimento alimento);
}