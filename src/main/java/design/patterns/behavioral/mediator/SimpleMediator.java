package design.patterns.behavioral.mediator;

// Mediator que centraliza el envío de mensajes entre usuarios.
public class SimpleMediator {
  // Recibe un mensaje de un usuario y lo muestra en consola.
  public void send(String msg, User user) {
    System.out.println(user.getName() + " dice: " + msg);
  }
}
