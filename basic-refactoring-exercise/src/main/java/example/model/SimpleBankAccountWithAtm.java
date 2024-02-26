package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    public static final int TRANSACTION_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - SimpleBankAccountWithAtm.TRANSACTION_FEE);
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount + SimpleBankAccountWithAtm.TRANSACTION_FEE);
    }

}
