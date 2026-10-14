/** Lab 2 - Challenge: static factory methods with a private constructor. */
public class Temperature {
    private final double celsius;

    private Temperature(double celsius) {      // callers cannot use 'new'
        this.celsius = celsius;
    }

    public static Temperature fromCelsius(double c) {
        return new Temperature(c);
    }

    public static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 5.0 / 9.0);
    }

    public double toCelsius()    { return celsius; }
    public double toFahrenheit() { return celsius * 9.0 / 5.0 + 32; }

    @Override
    public String toString() {
        return String.format("%.1f C / %.1f F", toCelsius(), toFahrenheit());
    }

    public static void main(String[] args) {
        System.out.println(Temperature.fromCelsius(100));
        System.out.println(Temperature.fromFahrenheit(32));
        System.out.println(Temperature.fromFahrenheit(98.6));
    }
}
