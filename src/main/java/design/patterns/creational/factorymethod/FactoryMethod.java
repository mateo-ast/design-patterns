package design.patterns.creational.factorymethod;

import java.util.Scanner;

import design.patterns.DesignPattern;

public class FactoryMethod implements DesignPattern {
    
    @Override
    public void run() {
        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.print("Que tipo de barco enemigo quieres? (UFO, Rocket o GranUFO): ");
            if (userInput.hasNextLine()) {
                String typeOfShip = userInput.nextLine();
                theEnemy = shipFactory.makeEnemyShip(typeOfShip);
            }
        }
        if (theEnemy != null) {
            doStuffEnemy(theEnemy);
        } else {
            System.out.println("Tipo de barco enemigo desconocido.");
        }
    }

    public static void doStuffEnemy(EnemyShip anEnemyShip) {
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
