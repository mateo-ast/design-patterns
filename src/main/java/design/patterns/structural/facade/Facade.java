package design.patterns.structural.facade;

import design.patterns.DesignPattern;

public class Facade implements DesignPattern{
    
    @Override
    public void run() {
        BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234);
        
        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(900.00);
        accessingBank.depositCash(200.00);
    }
}
