public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Grace", 45);
        Student s = new Student("Peter", 20, "Web Development");
        Teacher t = new Teacher("Mr Kimani", 38, "Java");

        // One display() method, written once in Person, reused by all three
        p.display();
        s.display();
        System.out.println("  course: " + s.getCourse());
        t.display();
        System.out.println("  subject: " + t.getSubject());

        System.out.println("Student is a Person? " + (s instanceof Person));
        System.out.println("Teacher is a Person? " + (t instanceof Person));
    }
}
