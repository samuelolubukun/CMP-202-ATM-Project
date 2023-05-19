package accounts;

public class SavingsAccount extends Account {
    private final int withdrawalLimit = 20000;
    public SavingsAccount(int initialBalance) {
        super(initialBalance);
    }
    public boolean withdraw(int amount) {
        if (amount > withdrawalLimit) {
            return false;
        }
        return super.withdraw(amount);
    }
}
