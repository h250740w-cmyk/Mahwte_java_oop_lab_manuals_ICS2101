import java.time.LocalDate;

/** Abstract parent of everything the library lends (Book, Dvd). */
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;
    private Loan currentLoan;                 // null when on the shelf

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank())       throw new IllegalArgumentException("Item id required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title required");
        this.id = id.trim();
        // Commas would break the CSV files, so they are replaced with spaces
        this.title = title.trim().replace(',', ' ');
    }

    /** Each kind of item has its own loan period (polymorphism). */
    public abstract int loanPeriodDays();

    /** One CSV line describing this item, e.g. BOOK,B1,Clean Code,Robert Martin. */
    public abstract String toCsv();

    public String getId()        { return id; }
    public String getTitle()     { return title; }
    public boolean isAvailable() { return available; }
    public Loan getCurrentLoan() { return currentLoan; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!available) {
            throw new ItemNotAvailableException(title);
        }
        Loan loan = new Loan(this, member, LocalDate.now());
        member.addLoan(loan);                 // throws if the member is at the limit; nothing changed yet
        this.currentLoan = loan;
        this.available = false;
    }

    @Override
    public void giveBack() {
        if (available) {
            throw new IllegalStateException("'" + title + "' is not on loan");
        }
        currentLoan.getMember().removeLoan(currentLoan);
        currentLoan = null;
        available = true;
    }

    /** Used only when reloading saved data: re-creates a loan with its ORIGINAL date. */
    void restoreLoan(Member member, LocalDate borrowedOn) {
        Loan loan = new Loan(this, member, borrowedOn);
        member.restoreLoan(loan);
        this.currentLoan = loan;
        this.available = false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-28s %-5s %s", id, title, getClass().getSimpleName(),
                available ? "available" : "ON LOAN (due " + currentLoan.getDueDate() + ")");
    }
}
