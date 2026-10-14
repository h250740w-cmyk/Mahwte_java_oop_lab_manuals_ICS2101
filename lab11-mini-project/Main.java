import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/** Console menu for the Library Management System. Usage: java Main [dataDirectory] */
public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Library library = new Library();
        LibraryStorage storage = new LibraryStorage(Path.of(args.length > 0 ? args[0] : "data"));
        storage.load(library);
        System.out.println("Loaded " + library.getItems().size() + " items and "
                + library.getMembers().size() + " members.");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = prompt("Choose");
            if (choice == null) break;                    // input ended (Ctrl+D / piped input)
            try {
                switch (choice.trim()) {
                    case "1" -> addItem(library);
                    case "2" -> registerMember(library);
                    case "3" -> borrow(library);
                    case "4" -> giveBack(library);
                    case "5" -> listOverdue(library);
                    case "6" -> search(library);
                    case "7" -> library.getItems().forEach(System.out::println);
                    case "8" -> library.getMembers().forEach(System.out::println);
                    case "0" -> running = false;
                    default  -> System.out.println("Please choose a number from the menu.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        storage.save(library);
        System.out.println("Data saved. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("""

                ===== LIBRARY MENU =====
                1) Add item         5) List overdue
                2) Register member  6) Search by title
                3) Borrow           7) List all items
                4) Return           8) List members
                0) Save and exit""");
    }

    private static String prompt(String label) {
        System.out.print(label + "> ");
        return in.hasNextLine() ? in.nextLine() : null;
    }

    private static String ask(String label) {
        String s = prompt(label);
        if (s == null) throw new IllegalStateException("Input ended");
        return s.trim();
    }

    private static void addItem(Library lib) {
        String type = ask("Type (B = book, D = dvd)").toUpperCase();
        String id = ask("Item id");
        String title = ask("Title");
        switch (type) {
            case "B" -> lib.addItem(new Book(id, title, ask("Author")));
            case "D" -> {
                try {
                    lib.addItem(new Dvd(id, title, Integer.parseInt(ask("Running time (minutes)"))));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Running time must be a whole number");
                }
            }
            default -> throw new IllegalArgumentException("Type must be B or D");
        }
        System.out.println("Item added.");
    }

    private static void registerMember(Library lib) {
        lib.registerMember(new Member(ask("Member id"), ask("Name")));
        System.out.println("Member registered.");
    }

    private static void borrow(Library lib) throws ItemNotAvailableException, MemberLimitExceededException {
        lib.borrow(ask("Member id"), ask("Item id"));
        System.out.println("Borrowed. Enjoy!");
    }

    private static void giveBack(Library lib) {
        lib.giveBack(ask("Item id"));
        System.out.println("Returned. Thank you!");
    }

    private static void listOverdue(Library lib) {
        List<Loan> overdue = lib.listOverdue(LocalDate.now());
        if (overdue.isEmpty()) System.out.println("Nothing is overdue.");
        else overdue.forEach(l -> System.out.println("OVERDUE: " + l));
    }

    private static void search(Library lib) {
        List<LibraryItem> found = lib.searchByTitle(ask("Search text"));
        if (found.isEmpty()) System.out.println("No matches.");
        else found.forEach(System.out::println);
    }
}
