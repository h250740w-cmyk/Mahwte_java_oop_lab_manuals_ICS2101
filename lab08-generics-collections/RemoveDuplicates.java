import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Lab 8 - Basic 2: a Set stores each value once. LinkedHashSet keeps the original order. */
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = List.of("Ann", "Bob", "Ann", "Cara", "Bob", "Dan", "Cara", "Ann");

        Set<String> unique = new LinkedHashSet<>(names);
        List<String> result = new ArrayList<>(unique);

        System.out.println("Original: " + names);
        System.out.println("Unique  : " + result);
    }
}
