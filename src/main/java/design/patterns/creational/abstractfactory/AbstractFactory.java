package design.patterns.creational.abstractfactory;

import design.patterns.DesignPattern;
import design.patterns.creational.abstractfactory.factoriaconcreta.CharmanderFactory;
import design.patterns.creational.abstractfactory.factoriaconcreta.PikachuFactory;
import design.patterns.creational.abstractfactory.cliente.Cliente;

public class Abstractfactory implements DesignPattern {
    @Override
    public void run() {
        System.out.println("=== Usando CharmanderFactory ===");
        Cliente clienteCharmander = new Cliente(new CharmanderFactory());
        clienteCharmander.jugar();
        
        System.out.println("\n=== Usando PikachuFactory ===");
        Cliente clientePikachu = new Cliente(new PikachuFactory());
        clientePikachu.jugar();
        
        System.out.println("\nEl patrón Abstract Factory permite que el cliente "
                + "use diferentes factories sin conocer sus implementaciones.");
    }
    
    public static void main(String[] args) {
        new Abstractfactory().run();
    }
}
