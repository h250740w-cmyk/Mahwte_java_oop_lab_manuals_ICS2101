/** Lab 6 - Intermediate 1: concrete deposit(), abstract monthlyFee(). */
public abstract class Account {
    private final String owner;
    protected double balance;

    protected Account(String owner, double openingBalance) {
        this.owner = owner;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public abstract double monthlyFee();      // each account type decides its own fee

    public void applyMonthlyFee() { balance -= monthlyFee(); }

    public String getOwner()   { return owner; }
    public double getBalance() { return balance; }
}
