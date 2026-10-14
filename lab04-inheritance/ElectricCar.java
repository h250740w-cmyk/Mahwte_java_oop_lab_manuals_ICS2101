public class ElectricCar extends Car {
    private final int batteryKwh;

    public ElectricCar(String make, int doors, int batteryKwh) {
        super(make, doors);
        this.batteryKwh = batteryKwh;
        System.out.println("3. ElectricCar constructor: " + batteryKwh + " kWh battery");
    }

    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        ElectricCar e = new ElectricCar("Nissan", 5, 40);
        System.out.println("Done: " + e.make + " " + e.doors + " doors, " + e.batteryKwh + " kWh");
    }
}
