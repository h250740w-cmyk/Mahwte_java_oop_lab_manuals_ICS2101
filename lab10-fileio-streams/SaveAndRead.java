import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Lab 10 - Basic 1: save five typed lines to a file, then read them back. */
public class SaveAndRead {
    public static void main(String[] args) {
        Path file = Path.of("notes.txt");
        Scanner in = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.hasNextLine() ? in.nextLine() : "(no input)");
        }

        try {
            Files.write(file, lines);                       // creates or overwrites
            System.out.println("\nSaved to " + file.toAbsolutePath().getFileName());

            System.out.println("Reading it back:");
            for (String line : Files.readAllLines(file)) {
                System.out.println("  > " + line);
            }
        } catch (IOException e) {
            System.out.println("File problem: " + e.getMessage());
        }
    }
}
