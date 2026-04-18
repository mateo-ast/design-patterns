package design.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

// ─────────────────────────────────────────────
// RECEIVER (Receptor)
// El objeto que realiza el trabajo real
// ─────────────────────────────────────────────
public class cocina {
    private List<String> pedidoActual = new ArrayList<>();

    public void agregarPlato(String plato) {
        pedidoActual.add(plato);
        System.out.println("  [Cocina] ✔ Preparando: " + plato);
    }

    public void quitarPlato(String plato) {
        pedidoActual.remove(plato);
        System.out.println("  [Cocina] ✖ Cancelado:  " + plato);
    }

    public void mostrarPedido() {
        System.out.println("  [Cocina] Pedido actual: " + pedidoActual);
    }
}