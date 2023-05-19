package accounts;

public class Account {
    private int balance;
    public Account(int initialBalance) {
        balance = initialBalance;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

}
