import java.time.LocalDate;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate borrowedOn;

    Loan(LibraryItem item, Member member, LocalDate borrowedOn) {
        if (item == null || member == null || borrowedOn == null) {
            throw new IllegalArgumentException("Loan needs an item, a member and a date");
        }
        this.item = item;
        this.member = member;
        this.borrowedOn = borrowedOn;
    }

    public LibraryItem getItem()     { return item; }
    public Member getMember()        { return member; }
    public LocalDate getBorrowedOn() { return borrowedOn; }

    public LocalDate getDueDate() { return borrowedOn.plusDays(item.loanPeriodDays()); }

    public boolean isOverdue(LocalDate today) { return today.isAfter(getDueDate()); }

    public String toCsv() { return member.getId() + "," + item.getId() + "," + borrowedOn; }

    @Override
    public String toString() {
        return item.getTitle() + " -> " + member.getName()
                + " (borrowed " + borrowedOn + ", due " + getDueDate() + ")";
    }
}
