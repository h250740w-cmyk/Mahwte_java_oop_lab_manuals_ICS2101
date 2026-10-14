import java.time.Year;

/** Lab 1 - Basic 1 and 2: Car class with display() and isAntique(). */
public class Car {
    String brand;
    int year;
    double mileage;

    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + " km");
    }

    // A car is antique when it is MORE than 25 years old
    boolean isAntique() {
        return Year.now().getValue() - year > 25;
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.year = 2018;
        c1.mileage = 85000;

        Car c2 = new Car();
        c2.brand = "Mazda";
        c2.year = 2005;
        c2.mileage = 190500.5;

        Car c3 = new Car();
        c3.brand = "Ford";
        c3.year = 1975;
        c3.mileage = 240000;

        Car[] cars = {c1, c2, c3};
        for (Car c : cars) {
            c.display();
            System.out.println("  Antique? " + c.isAntique());
        }
    }
}
