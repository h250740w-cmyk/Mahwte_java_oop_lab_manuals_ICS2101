/** Lab 9 - Basic 2: record Student(String name, int age). */
record Student(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {
        Student a = new Student("Imani", 21);
        Student b = new Student("Imani", 21);
        Student c = new Student("Joel", 19);

        System.out.println(a);                          // toString() generated: Student[name=Imani, age=21]
        System.out.println("a.equals(b) = " + a.equals(b));   // true: equal VALUES
        System.out.println("a == b      = " + (a == b));      // false: different objects
        System.out.println("a.equals(c) = " + a.equals(c));
        System.out.println("same hashCode for equal records: " + (a.hashCode() == b.hashCode()));
        System.out.println("name component = " + a.name() + ", age component = " + a.age());
    }
}
