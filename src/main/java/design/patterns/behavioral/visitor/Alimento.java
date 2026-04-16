// Alimento: el tercer tipo de producto.
public class Alimento implements Producto {

    private String nombre;
    private double precio;

    // Booleano: true si es perecedero (como lácteos), false si no (como enlatados)
    private boolean esPerecedero;

    public Alimento(String nombre, double precio, boolean esPerecedero) {
        this.nombre = nombre;
        this.precio = precio;
        this.esPerecedero = esPerecedero;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Getter del booleano: ¿es perecedero o no?
    public boolean isEsPerecedero() {
        return esPerecedero;
    }

    // Avisa al visitante que es un Alimento
    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarAlimento(this);
    }
}