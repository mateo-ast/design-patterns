package design.patterns.behavioral.command;

import java.util.Stack;

// ─────────────────────────────────────────────
// INVOKER (Invocador)
// Maneja el historial y dispara los comandos
// No sabe qué hace cada comando internamente
// ─────────────────────────────────────────────
public class Mesero {
    private final Stack<    Command> historial = new Stack<>();

    /** Ejecuta un comando y lo guarda para poder deshacerlo */
    public void tomarOrden(Command Command) {
        System.out.println("\n  → " + Command.descripcion());
        Command.ejecutar();
        historial.push(Command);
    }

    /** Deshace el último comando ejecutado */
    public void deshacerUltimaOrden() {
        if (historial.isEmpty()) {
            System.out.println("\n  [Mesero] No hay órdenes para deshacer.");
            return;
        }
        Command ultimo = historial.pop();
        System.out.println("\n  ← Deshaciendo: " + ultimo.descripcion());
        ultimo.deshacer();
    }

    /** Muestra el historial de comandos ejecutados */
    public void mostrarHistorial() {
        System.out.println("\n  [Historial de órdenes]");
        if (historial.isEmpty()) {
            System.out.println("  (vacío)");
        } else {
            historial.forEach(c -> System.out.println("    • " + c.descripcion()));
        }
    }
}