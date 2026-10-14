public record MobileMoneyPayment(double amount, String phone) implements Payment {
    @Override
    public void process() {
        System.out.printf("Sending mobile money request to %s: %.2f%n", phone, amount);
    }
}
