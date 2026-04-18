package design.patterns.creational.builder;

import design.patterns.DesignPattern;

// Esta clase implementa DesignPattern para integrarse
// al sistema del proyecto (se ejecuta desde App.java)
public class Builder implements DesignPattern {

    @Override
    public void run() {

        // Construimos la pizza PASO A PASO usando el Builder
        // Se encadenan los métodos uno tras otro
        Pizza pizza1 = new Pizza.PizzaBuilder("Grande")
                .conMasa("Delgada")
                .conSalsa("Tomate")
                .conQueso("Mozzarella")
                .conPepperoni()
                .build(); // <-- Este es el paso final que "termina" la pizza

        // También podemos hacer una pizza más simple, omitiendo ingredientes
        Pizza pizza2 = new Pizza.PizzaBuilder("Mediana")
                .conMasa("Gruesa")
                .conSalsa("BBQ")
                .conQueso("Cheddar")
                .conChampiñones()
                .build();

        // Mostramos las pizzas construidas
        System.out.println("Pizza 1: " + pizza1);
        System.out.println("Pizza 2: " + pizza2);
    }
}