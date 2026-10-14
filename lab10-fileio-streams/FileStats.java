import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Lab 10 - Intermediate 1: count lines, words and characters (like the Unix wc command). */
public class FileStats {
    public static void main(String[] args) throws IOException {
        Path file;
        if (args.length > 0) {
            file = Path.of(args[0]);
        } else {
            file = Path.of("sample.txt");                   // create a sample if none given
            Files.writeString(file, "Java is fun.\nObjects and classes everywhere.\n\nThe end.\n");
            System.out.println("(no file given - using generated sample.txt)");
        }

        if (!Files.exists(file)) {
            System.out.println("File not found: " + file);
            return;
        }

        List<String> lines = Files.readAllLines(file);
        int words = 0;
        for (String line : lines) {
            if (!line.isBlank()) words += line.trim().split("\\s+").length;
        }
        long chars = Files.readString(file).length();

        System.out.println("Lines     : " + lines.size());
        System.out.println("Words     : " + words);
        System.out.println("Characters: " + chars + " (includes newline characters)");
    }
}
