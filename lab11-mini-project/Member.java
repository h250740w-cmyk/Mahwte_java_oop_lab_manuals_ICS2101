import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Member id required");
        this.id = id.trim();
        setName(name);
    }

    public String getId()   { return id; }
    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Member name required");
        this.name = name.trim().replace(',', ' ');
    }

    /** Read-only view so outside code cannot bypass the loan limit. */
    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    void addLoan(Loan loan) throws MemberLimitExceededException {
        if (loans.size() >= MAX_LOANS) {
            throw new MemberLimitExceededException(name, MAX_LOANS);
        }
        loans.add(loan);
    }

    void restoreLoan(Loan loan) { loans.add(loan); }     // reload from disk, no limit check

    void removeLoan(Loan loan)  { loans.remove(loan); }

    public String toCsv() { return id + "," + name; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + loans.size() + "/" + MAX_LOANS + " loans)";
    }
}
