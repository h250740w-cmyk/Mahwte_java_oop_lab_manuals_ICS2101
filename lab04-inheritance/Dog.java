/**
 * Working version of Dog.
 *
 * The version that does NOT compile is:
 *
 *     class Dog extends Animal {
 *         Dog() { System.out.println("Dog created"); }
 *     }
 *
 * Why it fails: every constructor must start with a call to a superclass constructor.
 * If you do not write super(...), Java silently inserts super() - a call to a
 * NO-ARGUMENT Animal constructor. Animal(String name) is the only constructor, so the
 * default no-arg constructor does not exist and the compiler reports:
 *     constructor Animal in class Animal cannot be applied to given types
 * Fix: call super(name) explicitly (below), or add a no-arg constructor to Animal.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);                       // explicit call fixes the error
        System.out.println("Dog created: " + getName());
    }

    public static void main(String[] args) {
        new Dog("Rex");
    }
}
