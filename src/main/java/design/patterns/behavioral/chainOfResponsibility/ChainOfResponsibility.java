package design.patterns.behavioral.chainOfResponsibility;

import design.patterns.DesignPattern;

public class ChainOfResponsibility implements DesignPattern {
    
    @Override
    public void run() {
        // Crea los objetos que van a estar en la cadena
        Chain addChain = new AddNumbers();
        Chain subChain = new SubtractNumbers();
        Chain mulChain = new MultNumbers();
        Chain divChain = new DivideNumbers();
        
        // Setea la cadena de responsabilidad
        addChain.setNextChain(subChain);
        subChain.setNextChain(mulChain);
        mulChain.setNextChain(divChain);
        
        // Crea un objeto Numbers con los números y la operación deseada
        Numbers request = new Numbers(4, 2, "subtract");
        
        // Envía la solicitud a la cadena
        addChain.calculate(request);
    }
    
}
