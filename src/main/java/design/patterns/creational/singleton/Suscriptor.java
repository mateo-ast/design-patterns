package design.patterns.creational.singleton;

import java.util.Objects;

/**
 * Representa a un suscriptor del juego.
 *
 * Cada suscriptor se identifica por su correo electrónico.
 */
public class Suscriptor {
    // Correo único del suscriptor.
    private final String correo;

    /**
     * Crea un nuevo suscriptor con el correo indicado.
     * Se imprime un mensaje para demostrar cuándo se invoca el constructor.
     */
    public Suscriptor(String correo) {
        this.correo = correo;
        System.out.println("Suscriptor creado: " + correo);
    }

    /**
     * Devuelve el correo electrónico del suscriptor.
     */
    public String obtenerCorreo() {
        return correo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Suscriptor)) {
            return false;
        }
        Suscriptor otro = (Suscriptor) obj;
        return Objects.equals(correo, otro.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }

    @Override
    public String toString() {
        return "Suscriptor{" + "correo='" + correo + '\'' + '}';
    }
}
