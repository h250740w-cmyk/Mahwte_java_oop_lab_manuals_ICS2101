/** Lab 2 - Intermediate 1: auto-increment id, three overloaded constructors, copy constructor. */
public class Employee {
    private static int nextId = 1000;

    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: everything
    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor 2: name and department, salary defaults to 0
    public Employee(String name, String department) {
        this(name, department, 0.0);
    }

    // Constructor 3: name only
    public Employee(String name) {
        this(name, "Unassigned");
    }

    // Copy constructor: new object with a NEW id but the same details
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    @Override
    public String toString() {
        return "Employee#" + employeeId + " " + name + ", " + department + ", " + salary;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Wanjiru", "Finance", 4200);
        Employee e2 = new Employee("Otieno", "IT");
        Employee e3 = new Employee("Zawadi");
        Employee e4 = new Employee(e1);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4 + "   <- copy of e1, different id");
    }
}
