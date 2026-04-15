package design.patterns.structural.facade;

public class FundsCheck {
    
    private double cashInAccount = 1000.00;
    
    public double getCashInAccount() {
        return cashInAccount;
    }
    
    public void decreaseCashInAccount(double cashWithdrawn) {
        cashInAccount -= cashWithdrawn;
    }
    
    public void increaseCashInAccount(double cashDeposited) {
        cashInAccount += cashDeposited;
    }
    
    public boolean haveEnoughMoney(double cashToWithdraw) {
        if (cashToWithdraw > getCashInAccount()) {
            System.out.println("No tienes suficiente dinero");
            System.out.println("Tu saldo actual es: " + getCashInAccount() + "\n");
            return false;
        } else {
            decreaseCashInAccount(cashToWithdraw);
            System.out.println("Has retirado: " + cashToWithdraw);
            System.out.println("Tu saldo actual es: " + getCashInAccount() + "\n");
            return true;
        }
    }

    public void makeDeposit(double cashToDeposit) {
        increaseCashInAccount(cashToDeposit);
        System.out.println("Has depositado: " + cashToDeposit);
        System.out.println("Tu saldo actual es: " + getCashInAccount() + "\n");
    }
    
}
