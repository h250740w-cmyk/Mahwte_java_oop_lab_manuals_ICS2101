/** Lab 7 - Intermediate 2: checked exception carrying useful data. */
public class InsufficientFundsException extends Exception {
    private final double shortfall;

    public InsufficientFundsException(double balance, double requested) {
        super(String.format("Balance %.2f is less than requested %.2f", balance, requested));
        this.shortfall = requested - balance;
    }

    public double getShortfall() { return shortfall; }
}
