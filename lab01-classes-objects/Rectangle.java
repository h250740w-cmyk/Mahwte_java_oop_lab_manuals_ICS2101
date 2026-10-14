/** Lab 1 - Intermediate 1: Rectangle with area() and perimeter(); find the largest of 5. */
public class Rectangle {
    double width;
    double height;

    double area()      { return width * height; }
    double perimeter() { return 2 * (width + height); }

    static Rectangle of(double w, double h) {
        Rectangle r = new Rectangle();
        r.width = w;
        r.height = h;
        return r;
    }

    public static void main(String[] args) {
        Rectangle[] rects = {
            of(2, 3), of(5, 4), of(10, 1), of(6, 6), of(3.5, 2)
        };

        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            System.out.printf("%.1f x %.1f  area=%.1f  perimeter=%.1f%n",
                    r.width, r.height, r.area(), r.perimeter());
            if (r.area() > largest.area()) {
                largest = r;
            }
        }
        System.out.printf("Largest rectangle: %.1f x %.1f (area %.1f)%n",
                largest.width, largest.height, largest.area());
    }
}
