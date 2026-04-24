package design.patterns.creational.singleton;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Singleton que representa una base de datos de suscriptores del juego.
 *
 * Al usar un singleton garantizamos una única instancia de la base de datos
 * durante toda la ejecución de la aplicación.
 */
public class BaseDatosSuscriptores {
    // Instancia única del singleton.
    private static BaseDatosSuscriptores instancia;

    // Mapa de suscriptores registrado por correo electrónico.
    private final Map<String, Suscriptor> suscriptores = new LinkedHashMap<>();

    /**
     * Constructor privado para evitar instanciación externa.
     * Este constructor solo se ejecuta la primera vez que se obtiene el singleton.
     */
    private BaseDatosSuscriptores() {
    }

    /**
     * Devuelve la instancia única de BaseDatosSuscriptores.
     * Usa una única instancia simple para toda la aplicación.
     */
    public static BaseDatosSuscriptores obtenerInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosSuscriptores();
        }
        return instancia;
    }

    /**
     * Registra un suscriptor basado en su correo.
     * Si el correo ya existe, devuelve el mismo objeto existente.
     */
    public Suscriptor suscribir(String correo) {
        return suscriptores.computeIfAbsent(correo, Suscriptor::new);
    }

    /**
     * Devuelve la cantidad de suscriptores registrados.
     */
    public int obtenerCantidadSuscriptores() {
        return suscriptores.size();
    }

    /**
     * Devuelve la lista de suscriptores registrados en modo de solo lectura.
     */
    public Collection<Suscriptor> obtenerSuscriptores() {
        return Collections.unmodifiableCollection(suscriptores.values());
    }
}
