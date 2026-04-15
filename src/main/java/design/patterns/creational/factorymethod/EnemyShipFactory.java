package design.patterns.creational.factorymethod;

public class EnemyShipFactory {
    
    public EnemyShip makeEnemyShip(String newShipType) {
        EnemyShip newShip = null;
        
        switch (newShipType) {
            case "UFO" -> newShip = new UFOEnemyShip();
            case "Rocket" -> newShip = new RocketEnemyShip();
            case "GranUFO" -> newShip = new BigUFOEnemyShip();
            default -> {
                return null;
            }
        }
        
        return newShip;
    }
}
