/** Lab 4 - Intermediate 1: multilevel inheritance Vehicle -> Car -> ElectricCar. */
public class Vehicle {
    protected final String make;

    public Vehicle(String make) {
        this.make = make;
        System.out.println("1. Vehicle constructor: " + make);
    }
}
