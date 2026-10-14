import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Zuri", 68), new Student("Amos", 91),
            new Student("Mary", 55), new Student("Daudi", 77)));

        Collections.sort(list);                                   // uses compareTo (name)
        System.out.println("By name : " + list);

        Comparator<Student> byMarks = Comparator.comparingInt(Student::getMarks);
        list.sort(byMarks);                                       // ascending marks
        System.out.println("By marks: " + list);

        list.sort(byMarks.reversed());                            // highest first
        System.out.println("Top first: " + list);
    }
}
