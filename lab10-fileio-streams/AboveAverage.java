import java.util.List;

/** Lab 10 - Intermediate 2: streams. Names above the class average, alphabetically. */
public class AboveAverage {
    record Student(String name, double mark) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Zawadi", 82), new Student("Brian", 55), new Student("Amina", 91),
            new Student("Peter", 48), new Student("Mary", 76), new Student("Hassan", 67));

        double average = students.stream()
                .mapToDouble(Student::mark)
                .average()
                .orElse(0);
        System.out.printf("Class average: %.2f%n", average);

        System.out.println("Above average:");
        students.stream()
                .filter(s -> s.mark() > average)
                .map(Student::name)
                .sorted()
                .forEach(n -> System.out.println("  " + n));
    }
}
