package design.patterns.behavioral.mediator;

import design.patterns.DesignPattern;

public class Mediator implements DesignPattern {
  @Override
  public void run() {
    SimpleMediator mediator = new SimpleMediator();
    User a = new User("A", mediator);
    User b = new User("B", mediator);

    // A y B no se llaman directamente; usan el mediador para enviar mensajes.
    a.send("hola");
    b.send("buenos días");
  }
}
