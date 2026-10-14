public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] staff = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Rudo", 1000)          // capped at 800
        };

        // The payroll loop only knows about Employee. It never mentions Intern.
        double total = 0;
        for (Employee e : staff) {
            double pay = e.calculatePay();
            System.out.printf("%-8s %-10s %8.2f%n", e.getName(), e.getClass().getSimpleName(), pay);
            total += pay;
        }
        System.out.printf("TOTAL PAYROLL: %.2f%n", total);
    }
}
