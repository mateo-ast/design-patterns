package design.patterns.creational.singleton.game;

// Demo del singleton para una base de datos de suscriptores de juego.
public class SingletonDemo {
    public static void main(String[] args) {
        SubscriberDatabase database = SubscriberDatabase.getInstance();

        database.register("player1@game.com");
        database.register("player2@game.com");
        database.register("player1@game.com"); // correo repetido
        database.register("player3@game.com");

        System.out.println("Suscriptores únicos: " + database.count());
    }
}
