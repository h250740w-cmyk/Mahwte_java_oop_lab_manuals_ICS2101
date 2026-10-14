# Lab 6: Abstraction, Abstract Classes and Interfaces

## Files
- `Shape.java`, `Circle.java`, `Rectangle.java`, `Square.java`, `ShapeDemo.java` - Basic 1
- `Flyable.java`, `Bird.java`, `Aeroplane.java`, `FlyDemo.java` - Basic 2
- `Account.java`, `SavingsAccount.java`, `CurrentAccount.java`, `AccountDemo.java` - Intermediate 1
- `Student.java`, `StudentSortDemo.java` - Intermediate 2
- `Hello1.java`, `Hello2.java`, `DefaultConflict.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java ShapeDemo
java FlyDemo
java AccountDemo
java StudentSortDemo
java DefaultConflict
```

## Answers
**Basic 1 - Abstract Shape**
- `Shape` is abstract with abstract `area()` and `perimeter()`, so `new Shape()` will not compile.
- Circle, Rectangle and Square must implement both methods.
- `describe()` is a concrete method shared by all shapes.
- `Square extends Rectangle` and passes the same side as width and height.

**Basic 2 - Flyable interface**
- An interface lists what a class can do, with no fields or state.
- Bird and Aeroplane share no superclass but both `implements Flyable`.
- A `Flyable[]` can hold both. Interfaces give unrelated classes a common ability.

**Intermediate 1 - Account**
- `deposit()` is concrete (same for every account type).
- `monthlyFee()` is abstract (each type decides).
- SavingsAccount: 2.00 fee, waived at 1000 or more.
- CurrentAccount: flat 10.00 fee.
- Template idea: shared logic in the parent, the varying part left to subclasses.

**Intermediate 2 - Comparable and Comparator**
- `Student implements Comparable<Student>` with `compareTo` comparing names: this is the natural order.
- `Collections.sort(list)` uses it.
- `Comparator.comparingInt(Student::getMarks)` gives a second ordering without changing the class.
- `.reversed()` flips it for highest marks first.
- Comparable = one built-in order; Comparator = any number of external orders.

**Challenge - Default method conflict**
- Both `Hello1` and `Hello2` declare `default void hello()`.
- A class implementing both will not compile unless it overrides `hello()`.
- Inside the override, `Hello1.super.hello()` or `Hello2.super.hello()` picks a version.
- The rules, in order: a class method beats any interface default; a more specific interface beats a less specific one; if still ambiguous, the class must resolve it explicitly.
