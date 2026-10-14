public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        if (author == null || author.isBlank()) throw new IllegalArgumentException("Author required");
        this.author = author.trim().replace(',', ' ');
    }

    public String getAuthor() { return author; }

    @Override public int loanPeriodDays() { return 14; }

    @Override public String toCsv() { return "BOOK," + getId() + "," + getTitle() + "," + author; }

    @Override public String toString() { return super.toString() + "  by " + author; }
}
