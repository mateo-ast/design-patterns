// Este visitante calcula impuestos.
// Es OTRA operación completamente distinta, pero los productos
// no cambiaron ni una línea — solo agregamos este nuevo visitante.
// Eso es la gran ventaja del patrón Visitor.
public class VisitanteImpuesto implements Visitante {

    // Los libros están exentos de impuestos en muchos países
    @Override
    public void visitarLibro(Libro libro) {
        System.out.println("Libro '" + libro.getTitulo()
            + "' → Exento de impuestos. Precio final: $" + libro.getPrecio());
    }

    // Los electrodomésticos pagan 21% de IVA
    @Override
    public void visitarElectrodomestico(Electrodomestico e) {
        double impuesto = e.getPrecio() * 0.21; // 21% de IVA
        double precioFinal = e.getPrecio() + impuesto;
        System.out.println("Electrodoméstico '" + e.getNombre()
            + "' | IVA 21%: +$" + impuesto
            + " | Precio final: $" + precioFinal);
    }

    // Los alimentos pagan 10.5% de IVA reducido
    @Override
    public void visitarAlimento(Alimento alimento) {
        double impuesto = alimento.getPrecio() * 0.105; // 10.5% IVA reducido
        double precioFinal = alimento.getPrecio() + impuesto;
        System.out.println("Alimento '" + alimento.getNombre()
            + "' | IVA 10.5%: +$" + impuesto
            + " | Precio final: $" + precioFinal);
    }
}