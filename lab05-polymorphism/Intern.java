/** NEW subclass: the payroll loop below does not change at all. */
public class Intern extends Employee {
    private static final double STIPEND_CAP = 800.0;

    public Intern(String name, double requestedStipend) {
        super(name, Math.min(requestedStipend, STIPEND_CAP));
    }

    @Override public double calculatePay() { return baseSalary; }
}
