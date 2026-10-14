/** Design 1: ONE processor that checks types with instanceof pattern matching. */
public class PaymentProcessorV1 {
    public void pay(Payment p) {
        if (p instanceof CardPayment c) {
            String last4 = c.cardNumber().substring(c.cardNumber().length() - 4);
            System.out.printf("[V1] Charging card ending %s: %.2f%n", last4, c.amount());
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.printf("[V1] Sending mobile money request to %s: %.2f%n", m.phone(), m.amount());
        } else {
            throw new IllegalArgumentException("Unknown payment type: " + p.getClass());
        }
    }
}
