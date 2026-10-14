import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Lab 10 - Challenge: load learners.csv, group by grade band with Collectors.groupingBy,
 * and write one report file per band (report-A.txt, report-B.txt, report-C.txt).
 * Bands: A = gpa 3.5+, B = 3.0 to 3.49, C = below 3.0
 */
public class GroupLearners {
    record Learner(String name, int roll, double gpa) {
        static Learner fromCsv(String line) {
            String[] p = line.split(",");
            return new Learner(p[0].trim(), Integer.parseInt(p[1].trim()), Double.parseDouble(p[2].trim()));
        }

        String band() {
            if (gpa >= 3.5) return "A";
            if (gpa >= 3.0) return "B";
            return "C";
        }
    }

    public static void main(String[] args) throws IOException {
        Path input = Path.of(args.length > 0 ? args[0] : "learners.csv");
        if (!Files.exists(input)) {
            System.out.println("Cannot find " + input);
            return;
        }

        List<Learner> learners = Files.readAllLines(input).stream()
                .filter(line -> !line.isBlank())
                .map(Learner::fromCsv)
                .toList();

        Map<String, List<Learner>> byBand = learners.stream()
                .collect(Collectors.groupingBy(Learner::band));

        for (String band : List.of("A", "B", "C")) {
            List<Learner> members = byBand.getOrDefault(band, List.of());
            List<String> report = members.stream()
                    .map(l -> String.format("%-8s roll=%d gpa=%.2f", l.name(), l.roll(), l.gpa()))
                    .collect(Collectors.toCollection(java.util.ArrayList::new));
            report.add(0, "Band " + band + " - " + members.size() + " learner(s)");

            Path out = Path.of("report-" + band + ".txt");
            Files.write(out, report);
            System.out.println("Wrote " + out + " (" + members.size() + " learners)");
        }
    }
}
