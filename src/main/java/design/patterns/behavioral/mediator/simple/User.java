package design.patterns.behavioral.mediator.simple;

// Usuario que delega el envío de mensajes al mediador.
public class User {
    private final String name;
    private final SimpleMediator mediator;

    public User(String name, SimpleMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    // Envía un mensaje a través del mediador en lugar de comunicarse directamente.
    public void send(String msg) {
        mediator.send(msg, this);
    }
}
