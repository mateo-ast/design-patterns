package design.patterns.creational.singleton;

import design.patterns.DesignPattern;

public class Singleton implements DesignPattern {
  @Override
  public void run() {
    System.out.println("=== Demo Singleton de Suscriptores del Juego ===");

    // Se obtiene la instancia única del singleton.
    BaseDatosSuscriptores baseDatos = BaseDatosSuscriptores.obtenerInstancia();

    // Primer registro: se crea un nuevo suscriptor.
    baseDatos.suscribir("jugador1@ejemplo.com");

    // Segundo registro: se crea otro suscriptor distinto.
    baseDatos.suscribir("jugador2@ejemplo.com");

    // Tercer registro con el mismo correo que el primero: no se crea uno nuevo.
    baseDatos.suscribir("jugador1@ejemplo.com");

    // Cuarto registro: se crea un nuevo suscriptor distinto.
    baseDatos.suscribir("jugador3@ejemplo.com");

    // Muestra el total de suscriptores únicos.
    System.out.println("\nTotal de suscriptores registrados: " + baseDatos.obtenerCantidadSuscriptores());
    System.out.println("Suscriptores en la base de datos:");
    baseDatos.obtenerSuscriptores().forEach(suscriptor -> System.out.println(" - " + suscriptor.obtenerCorreo()));
  }
}
