import java.util.Arrays;

/**
 * Lab 8 - Challenge: generic bubble sort.
 *
 * Why int[] will not work: generics only work with reference types. T must be a class or
 * interface, and int is a primitive, so int[] is not a T[] for any T (int[] is not an
 * Integer[]). Java does not auto-box whole arrays. Use Integer[], or write a separate int[] version.
 */
public class BubbleSort {
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean swapped;
        for (int pass = 0; pass < arr.length - 1; pass++) {
            swapped = false;
            for (int i = 0; i < arr.length - 1 - pass; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;           // already sorted, stop early
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1, 7, 3};
        String[] words = {"pear", "apple", "mango", "banana"};

        bubbleSort(nums);
        bubbleSort(words);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));

        int[] primitive = {3, 1, 2};
        // bubbleSort(primitive);   // compile error: int[] cannot be converted to T[]
        System.out.println("int[] needs its own method (or boxing to Integer[]): " + primitive.length + " items");
    }
}
