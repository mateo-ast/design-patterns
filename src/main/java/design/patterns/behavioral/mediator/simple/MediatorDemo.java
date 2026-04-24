package design.patterns.behavioral.mediator.simple;

// Demo ultra simple del patrón Mediator.
public class MediatorDemo {
    public static void main(String[] args) {
        SimpleMediator mediator = new SimpleMediator();
        User a = new User("A", mediator);
        User b = new User("B", mediator);

        // A y B no se llaman directamente; usan el mediador para enviar mensajes.
        a.send("hola");
        b.send("buenos días");
    }
}
