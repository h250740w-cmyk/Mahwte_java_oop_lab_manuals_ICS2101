public class SavingsAccount extends Account {
    public SavingsAccount(String owner, double openingBalance) { super(owner, openingBalance); }

    // Savings: flat 2.00 fee, waived above 1000
    @Override public double monthlyFee() { return balance >= 1000 ? 0.0 : 2.00; }
}
