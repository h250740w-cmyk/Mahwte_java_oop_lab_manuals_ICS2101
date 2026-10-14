import java.util.Arrays;

/** Lab 5 - Basic 1: method overloading (same name, different parameter lists). */
public class PrintOverload {
    static void print(int x)      { System.out.println("int: " + x); }
    static void print(double x)   { System.out.println("double: " + x); }
    static void print(String s)   { System.out.println("String: " + s); }
    static void print(int[] arr)  { System.out.println("int[]: " + Arrays.toString(arr)); }

    public static void main(String[] args) {
        print(42);
        print(3.14);
        print("hello");
        print(new int[]{1, 2, 3});
        print('A');      // char is widened to int, so print(int) is chosen -> 65
        print(10L);      // long is widened to double (no print(long)) -> 10.0
    }
}
