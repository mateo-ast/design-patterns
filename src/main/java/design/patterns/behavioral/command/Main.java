package design.patterns.behavioral.command;

//─────────────────────────────────────────────
// CLIENT — Punto de entrada
// Crea los objetos y los conecta entre sí
// ─────────────────────────────────────────────
public class Main {

    public static void main(String[] args) {

        System.out.println("═══════════════════════════════════════");
        System.out.println("  RESTAURANTE — Patrón Command en acción");
        System.out.println("═══════════════════════════════════════");

        // Creamos el receptor y el invocador
        cocina cocina = new cocina();
        Mesero mesero = new Mesero();

        // El cliente crea los comandos y los pasa al invocador
        Command pedirPizza = new AgregarPlatoComando(cocina, "Pizza Margherita");
        Command pedirPasta = new AgregarPlatoComando(cocina, "Pasta Carbonara");
        Command pedirPostre = new AgregarPlatoComando(cocina, "Tiramisú");
        Command cancelarPasta = new CancelarPlatoComando(cocina, "Pasta Carbonara");

        System.out.println("\n--- Fase 1: Tomando la orden ---");
        mesero.tomarOrden(pedirPizza);
        mesero.tomarOrden(pedirPasta);
        mesero.tomarOrden(pedirPostre);

        cocina.mostrarPedido();

        System.out.println("\n--- Fase 2: El cliente cambia de opinión ---");
        mesero.tomarOrden(cancelarPasta);

        cocina.mostrarPedido();

        System.out.println("\n--- Fase 3: El mesero deshace la cancelación ---");
        mesero.deshacerUltimaOrden();

        cocina.mostrarPedido();

        System.out.println("\n--- Fase 4: Otro deshacer (quita el Tiramisú) ---");
        mesero.deshacerUltimaOrden();

        cocina.mostrarPedido();

        mesero.mostrarHistorial();

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("  FIN DE LA DEMOSTRACIÓN");
        System.out.println("═══════════════════════════════════════");
    }
}