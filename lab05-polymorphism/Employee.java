/** Lab 5 - Intermediate 1: employee hierarchy from Lab 4, extended with Intern. */
public class Employee {
    private final String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }

    public double calculatePay() { return baseSalary; }
}
