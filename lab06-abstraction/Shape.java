/** Lab 6 - Basic 1: abstract class; cannot be instantiated. */
public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    // Concrete method shared by all shapes
    public void describe() {
        System.out.printf("%s: area=%.2f perimeter=%.2f%n",
                getClass().getSimpleName(), area(), perimeter());
    }
}
