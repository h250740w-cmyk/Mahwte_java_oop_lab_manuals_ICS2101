/** Lab 2 - Basic 1 and 2: constructors, default radius, static instance counter. */
public class Circle {
    private static int count = 0;      // one copy shared by every Circle
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);                      // constructor chaining, default radius 1.0
    }

    public static int getCount() { return count; }

    public double area() { return Math.PI * radius * radius; }

    public static void main(String[] args) {
        Circle c1 = new Circle(2.5);
        Circle c2 = new Circle();
        Circle c3 = new Circle(4);
        System.out.printf("c1 area = %.2f%n", c1.area());
        System.out.printf("c2 area = %.2f (default radius 1.0)%n", c2.area());
        System.out.printf("c3 area = %.2f%n", c3.area());
        System.out.println("Circles created: " + Circle.getCount());
    }
}
