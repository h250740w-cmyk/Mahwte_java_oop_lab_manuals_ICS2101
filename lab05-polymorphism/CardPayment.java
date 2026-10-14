public record CardPayment(double amount, String cardNumber) implements Payment {
    @Override
    public void process() {
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        System.out.printf("Charging card ending %s: %.2f%n", last4, amount);
    }
}
