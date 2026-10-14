/**
 * Lab 3 - Challenge: stores kelvin internally, exposes Celsius and Fahrenheit.
 * Callers only use getCelsius()/getFahrenheit(), so if the internal unit changed
 * (say to Celsius) only this class would change - no caller would break.
 */
public class Temperature {
    private double kelvin;

    public Temperature(double kelvin) {
        setKelvin(kelvin);
    }

    public static Temperature ofCelsius(double c) {
        return new Temperature(c + 273.15);
    }

    public void setKelvin(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Below absolute zero: " + kelvin + " K");
        }
        this.kelvin = kelvin;
    }

    public void setCelsius(double c) { setKelvin(c + 273.15); }

    public double getKelvin()     { return kelvin; }
    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9.0 / 5.0 + 32; }

    public static void main(String[] args) {
        Temperature t = Temperature.ofCelsius(25);
        System.out.printf("%.2f K = %.1f C = %.1f F%n", t.getKelvin(), t.getCelsius(), t.getFahrenheit());

        t.setCelsius(-40);
        System.out.printf("%.1f C = %.1f F (the scales meet at -40)%n", t.getCelsius(), t.getFahrenheit());

        try {
            t.setCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
