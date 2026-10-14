/**
 * Trade-offs: returning boolean vs throwing a checked exception
 *
 *  boolean return : simple and cheap, but callers can IGNORE it (silent failure) and it
 *                   cannot say WHY it failed or by how much.
 *  checked exception : the compiler forces callers to deal with failure, and the exception
 *                   carries details (shortfall). Cost: more try/catch code, and exceptions
 *                   are slower, so they suit exceptional situations rather than normal flow.
 */
public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-7", 300);
        try {
            acc.withdraw(100);
            System.out.println("Withdrew 100, balance " + acc.getBalance());
            acc.withdraw(500);
            System.out.println("This line is never reached");
        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage());
            System.out.printf("You are short by %.2f%n", e.getShortfall());
        }
        System.out.println("Final balance " + acc.getBalance());
    }
}
