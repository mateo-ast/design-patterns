package design.patterns.behavioral.command;

import design.patterns.DesignPattern;

//─────────────────────────────────────────────
// CLIENT — Punto de entrada
// Crea los objetos y los conecta entre sí
// ─────────────────────────────────────────────

public class Command implements DesignPattern {
  @Override
  public void run() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("  RESTAURANTE — Patrón Command en acción");
        System.out.println("═══════════════════════════════════════");

        // Creamos el receptor y el invocador
        cocina cocina = new cocina();
        Mesero mesero = new Mesero();

        // El cliente crea los comandos y los pasa al invocador
        Comando pedirPizza = new AgregarPlatoComando(cocina, "Pizza Margherita");
        Comando pedirPasta = new AgregarPlatoComando(cocina, "Pasta Carbonara");
        Comando pedirPostre = new AgregarPlatoComando(cocina, "Tiramisú");
        Comando cancelarPasta = new CancelarPlatoComando(cocina, "Pasta Carbonara");

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