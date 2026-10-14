import java.util.ArrayList;
import java.util.List;

/**
 * Lab 3 - Intermediate 2: an immutable class.
 *
 * Design choices:
 *  - final class       : nobody can subclass it and add mutable behaviour.
 *  - private final fields : each field is assigned once, in the constructor.
 *  - no setters        : state cannot change after construction.
 *  - defensive copy in / out for the mutable List field, so outside code
 *    cannot change our state through a shared reference.
 */
public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final List<String> hobbies;

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.name = name;
        this.age = age;
        this.hobbies = List.copyOf(hobbies);   // defensive copy on the way in
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public List<String> getHobbies() {
        return hobbies;                         // already unmodifiable
    }

    // "Changing" a value returns a NEW object
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge, hobbies);
    }

    @Override
    public String toString() {
        return name + " (" + age + "), hobbies=" + hobbies;
    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>(List.of("football", "chess"));
        ImmutablePerson p = new ImmutablePerson("Asha", 20, hobbies);

        hobbies.add("swimming");               // changing the ORIGINAL list...
        System.out.println(p);                 // ...does not affect p

        ImmutablePerson older = p.withAge(21);
        System.out.println(p);
        System.out.println(older);
    }
}
