/**
 * Lab 1 - Intermediate 2: predict, then run.
 * Prediction: prints 20.0 because r2 is an alias of r1 (same object on the heap).
 */
public class RectangleAlias {
    public static void main(String[] args) {
        Rectangle r1 = Rectangle.of(5, 4);
        Rectangle r2 = r1;        // copies the REFERENCE, not the object
        r2.width = 20;            // changes the one shared object
        System.out.println("r1.width = " + r1.width);
        System.out.println("r1 == r2 ? " + (r1 == r2));
    }
}
