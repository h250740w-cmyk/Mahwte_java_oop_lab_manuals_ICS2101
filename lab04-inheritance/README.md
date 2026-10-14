# Lab 4: Inheritance

## Files
- `Person.java`, `Student.java`, `Teacher.java`, `PersonDemo.java` - Basic 1 and 2
- `Vehicle.java`, `Car.java`, `ElectricCar.java` - Intermediate 1
- `Animal.java`, `Dog.java` - Intermediate 2
- `BadStack.java`, `GoodStack.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java PersonDemo
java ElectricCar
java Dog
java BadStack
java GoodStack
```

## Answers
**Basic 1 and 2 - Person, Student, Teacher**
- `Person` holds `name`, `age` and `display()`.
- `Student extends Person` adds `course`; `Teacher extends Person` adds `subject`.
- Neither subclass rewrites `display()`; both inherit it (code reuse).
- `student instanceof Person` and `teacher instanceof Person` are both true (IS-A).

**Intermediate 1 - Constructor order (multilevel)**
- Creating an `ElectricCar` prints: Vehicle constructor, then Car constructor, then ElectricCar constructor.
- Each constructor begins with `super(...)`, so the parent finishes first.
- Construction runs top-down: the base class is built before the part that depends on it.

**Intermediate 2 - Why `class Dog extends Animal` can fail to compile**
- `Animal` only has `Animal(String name)`, so it has no no-argument constructor.
- Every constructor must begin with a call to a superclass constructor.
- If you do not write one, Java inserts `super()` automatically.
- `super()` needs a no-arg `Animal` constructor, which does not exist, so the compiler reports an error.
- Fix 1: write `super(name);` in `Dog` (done in `Dog.java`).
- Fix 2: add a no-arg constructor to `Animal`.
- The exact broken code is shown in the comment at the top of `Dog.java`.

**Challenge - Stack: inheritance vs composition**
- `BadStack extends ArrayList<Integer>` inherits ALL ArrayList methods.
- Callers can call `add(0, x)` or `remove(1)` and break last-in-first-out order (the demo does exactly this).
- `GoodStack` contains a private ArrayList and only exposes `push`, `pop`, `peek`, `isEmpty`, `size`.
- Rule of thumb: use inheritance for a real IS-A relationship; use composition for HAS-A or "uses".
- A Stack is not really an ArrayList (it restricts access), so composition is the correct design.
