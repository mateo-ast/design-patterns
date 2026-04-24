package design.patterns.creational.singleton.game;

// Representa un suscriptor identificado por su correo electrónico.
public class Subscriber {
    private final String email;

    public Subscriber(String email) {
        this.email = email;
        System.out.println("Nuevo suscriptor creado: " + email);
    }

    public String getEmail() {
        return email;
    }
}
