import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/** Lab 8 - Intermediate 2: word frequencies, sorted by count (high to low). */
public class WordFrequency {
    public static void main(String[] args) {
        String sample = "the cat sat on the mat and the dog sat on the log";
        String text;

        Scanner in = new Scanner(System.in);
        System.out.println("Type a paragraph and press Enter (blank = use sample text):");
        text = in.hasNextLine() ? in.nextLine() : "";
        if (text.isBlank()) text = sample;

        Map<String, Integer> freq = new HashMap<>();
        for (String w : text.toLowerCase().split("\\W+")) {
            if (w.isEmpty()) continue;
            freq.merge(w, 1, Integer::sum);          // add 1, or start at 1
        }

        // Sort entries by count descending, then alphabetically to break ties
        List<Map.Entry<String, Integer>> entries = new java.util.ArrayList<>(freq.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()));

        for (Map.Entry<String, Integer> e : entries) {
            System.out.printf("%-6s %d%n", e.getKey(), e.getValue());
        }
    }
}
