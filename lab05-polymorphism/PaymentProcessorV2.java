/** Design 2: polymorphic. The processor never asks "what kind are you?". */
public class PaymentProcessorV2 {
    public void pay(Payment p) {
        p.process();
    }
}
