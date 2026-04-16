// Este visitante aplica descuentos.
// Implementa Visitante, entonces DEBE definir qué hace con cada producto.
// La lógica de descuento está AQUÍ, no en los productos.
// Si mañana cambian los descuentos, solo tocamos este archivo.
public class VisitanteDescuento implements Visitante {

    // Cuando visita un Libro: 20% de descuento (los libros tienen buen descuento)
    @Override
    public void visitarLibro(Libro libro) {
        double descuento = libro.getPrecio() * 0.20; // 20% del precio
        double precioFinal = libro.getPrecio() - descuento;
        System.out.println("Libro '" + libro.getTitulo() + "'"
            + " | Precio original: $" + libro.getPrecio()
            + " | Descuento 20%: -$" + descuento
            + " | Precio final: $" + precioFinal);
    }

    // Cuando visita un Electrodoméstico: 10% de descuento
    @Override
    public void visitarElectrodomestico(Electrodomestico e) {
        double descuento = e.getPrecio() * 0.10; // 10% del precio
        double precioFinal = e.getPrecio() - descuento;
        System.out.println("Electrodoméstico '" + e.getNombre() + "'"
            + " | Precio original: $" + e.getPrecio()
            + " | Descuento 10%: -$" + descuento
            + " | Precio final: $" + precioFinal);
    }

    // Cuando visita un Alimento: si es perecedero 30% de descuento,
    // si no es perecedero 5% de descuento
    @Override
    public void visitarAlimento(Alimento alimento) {
        // Operador ternario: condición ? valor_si_true : valor_si_false
        double porcentaje = alimento.isEsPerecedero() ? 0.30 : 0.05;
        double descuento = alimento.getPrecio() * porcentaje;
        double precioFinal = alimento.getPrecio() - descuento;
        System.out.println("Alimento '" + alimento.getNombre() + "'"
            + " | Precio original: $" + alimento.getPrecio()
            + " | Descuento " + (porcentaje * 100) + "%: -$" + descuento
            + " | Precio final: $" + precioFinal);
    }
}