import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Core service: owns the items and members, enforces the business rules. */
public class Library {
    private final Map<String, LibraryItem> items = new LinkedHashMap<>();
    private final Map<String, Member> members = new LinkedHashMap<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("An item with id " + item.getId() + " already exists");
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("A member with id " + member.getId() + " already exists");
        }
        members.put(member.getId(), member);
    }

    public LibraryItem getItem(String id) {
        LibraryItem item = items.get(id);
        if (item == null) throw new IllegalArgumentException("No item with id " + id);
        return item;
    }

    public Member getMember(String id) {
        Member m = members.get(id);
        if (m == null) throw new IllegalArgumentException("No member with id " + id);
        return m;
    }

    public Collection<LibraryItem> getItems()   { return Collections.unmodifiableCollection(items.values()); }
    public Collection<Member> getMembers()      { return Collections.unmodifiableCollection(members.values()); }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = getMember(memberId);       // 1. look up (IllegalArgumentException if missing)
        LibraryItem item = getItem(itemId);
        item.borrow(member);                       // 2 + 3. checks availability and limit, records the loan
    }

    public void giveBack(String itemId) {
        getItem(itemId).giveBack();
    }

    /** Loans that are past their due date on the given day, oldest due date first. */
    public List<Loan> listOverdue(LocalDate today) {
        return items.values().stream()
                .map(LibraryItem::getCurrentLoan)
                .filter(loan -> loan != null && loan.isOverdue(today))
                .sorted(Comparator.comparing(Loan::getDueDate))
                .toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        String needle = text.toLowerCase();
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(needle))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }
}
