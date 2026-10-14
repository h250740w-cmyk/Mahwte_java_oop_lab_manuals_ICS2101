/** Lab 4 - Basic 1 and 2: base class shared by Student and Teacher. */
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    // Inherited by every subclass
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
