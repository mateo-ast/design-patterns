// Electrodoméstico: otro tipo de producto de la tienda.
public class Electrodomestico implements Producto {

    private String nombre;
    private double precio;

    public Electrodomestico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Al aceptar al visitante, le avisa que es un Electrodoméstico.
    // El visitante sabrá qué hacer específicamente con él.
    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarElectrodomestico(this);
    }
}