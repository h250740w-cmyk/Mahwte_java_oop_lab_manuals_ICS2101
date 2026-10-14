public class CurrentAccount extends Account {
    public CurrentAccount(String owner, double openingBalance) { super(owner, openingBalance); }

    // Current: flat 10.00 fee always
    @Override public double monthlyFee() { return 10.00; }
}
