package design.patterns.structural.facade;

public class BankAccountFacade {
    
    private int accountNumber;
    private int securityCode;

    AccountNumberCheck acctChecker;
    SecurityCodeCheck codeChecker;
    FundsCheck fundChecker;

    WelcomeToBank bankWelcome;
    public BankAccountFacade(int newAcctNum, int newSecCode) {
        this.accountNumber = newAcctNum;
        this.securityCode = newSecCode;

        bankWelcome = new WelcomeToBank();
        acctChecker = new AccountNumberCheck();
        codeChecker = new SecurityCodeCheck();
        fundChecker = new FundsCheck();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void withdrawCash(double cashToGet) {
        if (acctChecker.accountActive(getAccountNumber()) &&
            codeChecker.isCodeCorrect(getSecurityCode()) &&
            fundChecker.haveEnoughMoney(cashToGet)) {
                System.out.println("Transaccion Exitosa: Retirando " + cashToGet + "\n");
                fundChecker.decreaseCashInAccount(cashToGet);
        } else {
            System.out.println("Transaccion Fallida: No se pudo retirar " + cashToGet + "\n");
        }
    }

    public void depositCash(double cashToDeposit) {
        if (acctChecker.accountActive(getAccountNumber()) &&
            codeChecker.isCodeCorrect(getSecurityCode())) {
                System.out.println("Transaccion Exitosa: Depositando " + cashToDeposit + "\n");
                fundChecker.makeDeposit(cashToDeposit);
        } else {
            System.out.println("Transaccion Fallida: No se pudo depositar " + cashToDeposit);
        }
    }
    
}
