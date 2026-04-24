package design.patterns.creational.singleton.game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Singleton que gestiona suscriptores únicos del juego.
public class SubscriberDatabase {
    private static SubscriberDatabase instance;
    private final Map<String, Subscriber> subscribers = new ConcurrentHashMap<>();

    private SubscriberDatabase() {
        System.out.println("SubscriberDatabase creado");
    }

    public static synchronized SubscriberDatabase getInstance() {
        if (instance == null) {
            instance = new SubscriberDatabase();
        }
        return instance;
    }

    public Subscriber register(String email) {
        return subscribers.computeIfAbsent(email, Subscriber::new);
    }

    public int count() {
        return subscribers.size();
    }
}
