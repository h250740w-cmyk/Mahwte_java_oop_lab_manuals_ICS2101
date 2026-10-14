/**
 * Lab 5 - Intermediate 2: output differs for a METHOD and a FIELD
 * accessed through a superclass reference.
 *
 *  - Methods are resolved at RUNTIME from the real object type (overriding).
 *  - Fields are resolved at COMPILE TIME from the reference type (hiding, no polymorphism).
 */
public class FieldVsMethod {
    static class Parent {
        String name = "Parent field";
        String who() { return "Parent method"; }
    }

    static class Child extends Parent {
        String name = "Child field";            // HIDES Parent.name, does not override it
        @Override String who() { return "Child method"; }
    }

    public static void main(String[] args) {
        Parent p = new Child();                 // reference type Parent, object type Child

        System.out.println(p.who());            // Child method  (runtime type)
        System.out.println(p.name);             // Parent field  (compile-time type)
        System.out.println(((Child) p).name);   // Child field   (after casting)
    }
}
