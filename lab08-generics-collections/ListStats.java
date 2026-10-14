import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Lab 8 - Basic 1: sum, maximum and reverse of 10 integers in an ArrayList. */
public class ListStats {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(14, 7, 92, 3, 55, 28, 61, 9, 40, 76));

        int sum = 0;
        for (int n : nums) sum += n;

        System.out.println("List    : " + nums);
        System.out.println("Sum     : " + sum);
        System.out.println("Maximum : " + Collections.max(nums));

        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);
        System.out.println("Reversed: " + reversed);
    }
}
