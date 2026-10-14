# Lab 2: Constructors, this and static

## Files
- `Circle.java` - Basic 1 and 2
- `Employee.java` - Intermediate 1
- `InitBlocks.java` - Intermediate 2
- `Temperature.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java Circle
java Employee
java InitBlocks
java Temperature
```

## Answers
**Basic 1 and 2 - Circle**
- `Circle(double radius)` sets the radius.
- `Circle()` calls `this(1.0)`, so the default radius is 1.0 (constructor chaining).
- `private static int count` is one shared copy, increased in the main constructor.
- `static int getCount()` reads it without needing an object.

**Intermediate 1 - Employee**
- `private static int nextId` gives every new employee a unique id (`nextId++`).
- Three overloaded constructors: (name, department, salary), (name, department), (name).
- The shorter ones call `this(...)` so the real work happens in one place.
- Copy constructor `Employee(Employee other)` copies name, department and salary, but gets a NEW id.

**Intermediate 2 - Static and instance blocks**
- Prediction: both static blocks run once, in written order, when the class loads (before `main`).
- For each `new InitBlocks()`: instance block 1, instance block 2, then the constructor body.
- Static runs once per class; instance runs once per object.

**Challenge - Temperature static factories**
- The constructor is `private`, so callers must use `fromCelsius` or `fromFahrenheit`.
- Why static factories can be clearer than overloaded constructors:
  - Overloads need different parameter types, but Celsius and Fahrenheit are both `double`, so two constructors would clash.
  - A method name says what it does: `fromFahrenheit(98.6)` is clear; `new Temperature(98.6)` is not.
  - A factory can validate, cache, or return a subclass; a constructor cannot.
