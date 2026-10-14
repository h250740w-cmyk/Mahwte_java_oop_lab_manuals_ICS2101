public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("Ali", 500),
            new SavingsAccount("Beth", 2500),
            new CurrentAccount("Chege", 800)
        };
        for (Account a : accounts) {
            a.deposit(100);
            double before = a.getBalance();
            a.applyMonthlyFee();
            System.out.printf("%-6s %-15s before=%.2f fee=%.2f after=%.2f%n",
                    a.getOwner(), a.getClass().getSimpleName(),
                    before, before - a.getBalance(), a.getBalance());
        }
    }
}
