package design.patterns.behavioral.chainofresponsibility;

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
        Numbers request = new Numbers(4, 4, "divide");
        Numbers request1 = new Numbers(2, 4, "mult");
        Numbers request2 = new Numbers(3, 5, "add");
        Numbers request3 = new Numbers(4, 0, "divide");
        Numbers request4 = new Numbers(10, 5, "subtract");
        Numbers request5 = new Numbers(10, 5, "mod");
        
        // Envía la solicitud a la cadena
        addChain.calculate(request);
        addChain.calculate(request1);
        addChain.calculate(request2);
        addChain.calculate(request3);
        addChain.calculate(request4);
        addChain.calculate(request5);
    }
    
}
