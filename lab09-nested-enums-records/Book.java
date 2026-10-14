import java.util.Objects;

/** Lab 9 - Intermediate 1: equality by ISBN only. */
public class Book {
    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn()  { return isbn; }
    public String getTitle() { return title; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }

    // Contract: equal objects MUST have equal hash codes, so use the same field(s)
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() { return title + " [" + isbn + "]"; }
}
