package design.patterns.behavioral.visitor;

import design.patterns.DesignPattern;
import java.util.ArrayList;
import java.util.List;

public class Visitor implements DesignPattern {

    @Override
    public void run() {

        // Creamos los productos
        Libro libro1 = new Libro("Clean Code", 3500);
        Electrodomestico micro = new Electrodomestico("Microondas", 45000);
        Alimento leche = new Alimento("Leche", 800, true);
        Alimento arroz = new Alimento("Arroz", 600, false);

        List<Producto> tienda = new ArrayList<>();
        tienda.add(libro1);
        tienda.add(micro);
        tienda.add(leche);
        tienda.add(arroz);

        Visitante descuento = new VisitanteDescuento();
        Visitante impuesto = new VisitanteImpuesto();

        System.out.println("===== DESCUENTOS =====");
        for (Producto p : tienda) {
            p.aceptar(descuento);
        }

        System.out.println();

        System.out.println("===== IMPUESTOS =====");
        for (Producto p : tienda) {
            p.aceptar(impuesto);
        }
    }
}
