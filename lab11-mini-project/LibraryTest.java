import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

/**
 * Simple self-checking tests (no JUnit needed).  Run:  java LibraryTest
 * Exits with an error if any check fails.
 */
public class LibraryTest {
    private static int passed = 0;

    private static void check(String name, boolean condition) {
        if (!condition) throw new AssertionError("FAILED: " + name);
        passed++;
        System.out.println("PASS  " + name);
    }

    public static void main(String[] args) throws Exception {
        Library lib = new Library();
        lib.addItem(new Book("B1", "Clean Code", "Robert Martin"));
        lib.addItem(new Book("B2", "Effective Java", "Joshua Bloch"));
        lib.addItem(new Book("B3", "Java Concurrency", "Brian Goetz"));
        lib.addItem(new Dvd("D1", "The Matrix", 136));
        lib.registerMember(new Member("M1", "Amina"));
        lib.registerMember(new Member("M2", "Brian"));

        // Polymorphism: different loan periods
        check("book loan period is 14 days", lib.getItem("B1").loanPeriodDays() == 14);
        check("dvd loan period is 7 days",   lib.getItem("D1").loanPeriodDays() == 7);

        // Normal borrow
        lib.borrow("M1", "B1");
        check("borrowed item is unavailable", !lib.getItem("B1").isAvailable());
        check("member has 1 loan", lib.getMember("M1").getLoans().size() == 1);

        // Item not available
        try { lib.borrow("M2", "B1"); check("second borrow must fail", false); }
        catch (ItemNotAvailableException e) { check("ItemNotAvailableException thrown", true); }

        // Member limit
        lib.borrow("M1", "B2");
        lib.borrow("M1", "B3");
        try { lib.borrow("M1", "D1"); check("4th loan must fail", false); }
        catch (MemberLimitExceededException e) { check("MemberLimitExceededException thrown", true); }
        check("failed borrow left DVD available", lib.getItem("D1").isAvailable());

        // Missing ids
        try { lib.borrow("NOPE", "B1"); check("unknown member must fail", false); }
        catch (IllegalArgumentException e) { check("unknown member rejected", true); }

        // Return
        lib.giveBack("B1");
        check("returned item available again", lib.getItem("B1").isAvailable());
        check("member back to 2 loans", lib.getMember("M1").getLoans().size() == 2);

        // Overdue: ask 20 days into the future (books are due after 14)
        check("nothing overdue today", lib.listOverdue(LocalDate.now()).isEmpty());
        check("2 books overdue in 20 days", lib.listOverdue(LocalDate.now().plusDays(20)).size() == 2);

        // Streams search
        check("search 'java' finds 2", lib.searchByTitle("JAVA").size() == 2);
        check("search results sorted by title",
                lib.searchByTitle("java").get(0).getTitle().equals("Effective Java"));

        // Persistence round trip, including an old loan date
        Path dir = Files.createTempDirectory("librarytest");
        LibraryStorage storage = new LibraryStorage(dir);
        storage.save(lib);
        Library reloaded = new Library();
        storage.load(reloaded);
        check("items reloaded", reloaded.getItems().size() == 4);
        check("members reloaded", reloaded.getMembers().size() == 2);
        check("loan reloaded", !reloaded.getItem("B2").isAvailable());
        check("loan date preserved",
                reloaded.getItem("B2").getCurrentLoan().getBorrowedOn()
                        .equals(lib.getItem("B2").getCurrentLoan().getBorrowedOn()));
        check("member loans rebuilt", reloaded.getMember("M1").getLoans().size() == 2);

        System.out.println("\nAll " + passed + " checks passed.");
    }
}
