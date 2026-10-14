import java.util.HashSet;
import java.util.Set;

public class BookDemo {
    public static void main(String[] args) {
        Set<Book> shelf = new HashSet<>();

        System.out.println("add Clean Code        -> " + shelf.add(new Book("978-0132350884", "Clean Code")));
        System.out.println("add Effective Java    -> " + shelf.add(new Book("978-0134685991", "Effective Java")));
        // Same ISBN, different title and a different object: still a duplicate
        System.out.println("add Clean Code (copy) -> " + shelf.add(new Book("978-0132350884", "Clean Code, 2nd copy")));

        System.out.println("Set size = " + shelf.size() + " (duplicate rejected)");
        System.out.println(shelf);
    }
}
