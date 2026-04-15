package design.patterns.behavioral.chainofresponsibility;

public class DivideNumbers implements Chain {
    
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if ("divide".equals(request.getCalculationWanted())) {
            if (request.getNumber2() == 0) {
                System.out.println("Error: division por cero no permitida");
            } else {
                System.out.println(request.getNumber1() + " / " + request.getNumber2() + " = " + (request.getNumber1() / request.getNumber2()));
            }
        } else if (nextInChain != null) {
            nextInChain.calculate(request);
        } else {
            System.out.println("Solo se pueden realizar las operaciones suma, resta, multiplicacion y division");
        }
    }


}
