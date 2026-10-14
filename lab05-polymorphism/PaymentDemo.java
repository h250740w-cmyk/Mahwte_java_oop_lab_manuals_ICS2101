/**
 * Comparison:
 *  V1 (instanceof): all logic in one place, easy to read for 2 types, but EVERY new payment
 *      type forces an edit to the processor (and a forgotten branch only fails at runtime).
 *  V2 (polymorphism): adding a new payment type means writing one new class; the processor
 *      is never touched (open/closed principle). Logic lives with the data it uses.
 */
public class PaymentDemo {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(120.50, "4111111111111234"),
            new MobileMoneyPayment(45.00, "+254700111222")
        };

        PaymentProcessorV1 v1 = new PaymentProcessorV1();
        PaymentProcessorV2 v2 = new PaymentProcessorV2();

        for (Payment p : payments) v1.pay(p);
        System.out.println("---");
        for (Payment p : payments) v2.pay(p);
    }
}
