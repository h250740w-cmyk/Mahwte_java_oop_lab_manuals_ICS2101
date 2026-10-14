import java.util.ArrayList;
import java.util.List;

/** Lab 3 - Intermediate 1: BankAccount with a transaction history. */
public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add("OPEN " + openingBalance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        history.add("DEPOSIT " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) {
            history.add("FAILED WITHDRAW " + amount);
            return false;
        }
        balance -= amount;
        history.add("WITHDRAW " + amount);
        return true;
    }

    /**
     * Returns an UNMODIFIABLE COPY. Returning the private list itself would let callers
     * add, remove or edit history entries and break encapsulation.
     */
    public List<String> getHistory() {
        return List.copyOf(history);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Juma", 500);
        acc.deposit(250);
        acc.withdraw(100);
        acc.withdraw(5000);               // fails, still logged

        List<String> copy = acc.getHistory();
        copy.forEach(System.out::println);
        System.out.println("Balance: " + acc.getBalance());

        try {
            copy.add("DEPOSIT 1000000");  // tampering attempt
        } catch (UnsupportedOperationException e) {
            System.out.println("History cannot be modified from outside");
        }
        System.out.println("History size is still " + acc.getHistory().size());
    }
}
