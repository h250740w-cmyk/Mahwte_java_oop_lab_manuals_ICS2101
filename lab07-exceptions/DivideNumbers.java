import java.util.Scanner;

/** Lab 7 - Basic 1: read two ints, divide, handle bad input and division by zero. */
public class DivideNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter first integer: ");
            int a = Integer.parseInt(in.nextLine().trim());
            System.out.print("Enter second integer: ");
            int b = Integer.parseInt(in.nextLine().trim());

            System.out.println(a + " / " + b + " = " + (a / b));   // ArithmeticException if b == 0
        } catch (NumberFormatException e) {
            System.out.println("Error: that was not a whole number (" + e.getMessage() + ")");
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Error: no input supplied");
        } finally {
            System.out.println("Program finished.");
        }
    }
}
