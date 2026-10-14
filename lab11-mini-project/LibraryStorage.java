import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Saves and loads a Library as three CSV files: items.csv, members.csv, loans.csv. */
public class LibraryStorage {
    private final Path itemsFile;
    private final Path membersFile;
    private final Path loansFile;

    public LibraryStorage(Path directory) throws IOException {
        Files.createDirectories(directory);
        itemsFile   = directory.resolve("items.csv");
        membersFile = directory.resolve("members.csv");
        loansFile   = directory.resolve("loans.csv");
    }

    public void save(Library library) throws IOException {
        List<String> itemLines = new ArrayList<>();
        List<String> loanLines = new ArrayList<>();
        for (LibraryItem item : library.getItems()) {
            itemLines.add(item.toCsv());
            if (item.getCurrentLoan() != null) loanLines.add(item.getCurrentLoan().toCsv());
        }
        List<String> memberLines = library.getMembers().stream().map(Member::toCsv).toList();

        Files.write(itemsFile, itemLines);
        Files.write(membersFile, memberLines);
        Files.write(loansFile, loanLines);
    }

    /** Loads into an (empty) library. Missing files simply mean a first run. */
    public void load(Library library) throws IOException {
        for (String line : readLines(membersFile)) {
            try {
                String[] p = line.split(",", -1);
                library.registerMember(new Member(p[0], p[1]));
            } catch (RuntimeException e) {
                System.out.println("Skipping bad member line '" + line + "': " + e.getMessage());
            }
        }
        for (String line : readLines(itemsFile)) {
            try {
                String[] p = line.split(",", -1);
                LibraryItem item = switch (p[0]) {
                    case "BOOK" -> new Book(p[1], p[2], p[3]);
                    case "DVD"  -> new Dvd(p[1], p[2], Integer.parseInt(p[3]));
                    default -> throw new IllegalArgumentException("unknown type " + p[0]);
                };
                library.addItem(item);
            } catch (RuntimeException e) {
                System.out.println("Skipping bad item line '" + line + "': " + e.getMessage());
            }
        }
        for (String line : readLines(loansFile)) {
            try {
                String[] p = line.split(",", -1);
                library.getItem(p[1]).restoreLoan(library.getMember(p[0]), LocalDate.parse(p[2]));
            } catch (RuntimeException e) {
                System.out.println("Skipping bad loan line '" + line + "': " + e.getMessage());
            }
        }
    }

    private List<String> readLines(Path file) throws IOException {
        if (!Files.exists(file)) return List.of();
        return Files.readAllLines(file).stream().filter(l -> !l.isBlank()).toList();
    }
}
