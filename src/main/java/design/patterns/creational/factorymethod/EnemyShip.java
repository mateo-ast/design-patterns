package design.patterns.creational.factorymethod;

public abstract class EnemyShip {
    private String name;
    private double amtDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHeroShip() {
        System.out.println(getName() + " esta siguiendo al heroe.");
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " esta en pantalla.");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + " ataca y hace " + getAmtDamage() + " puntos de daño.");
    }
    
}
