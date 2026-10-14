# Lab 5: Polymorphism

## Files
- `PrintOverload.java` - Basic 1
- `Animal.java`, `Cat.java`, `Cow.java`, `Duck.java`, `AnimalDemo.java` - Basic 2
- `Employee.java`, `Manager.java`, `Developer.java`, `Intern.java`, `PayrollDemo.java` - Intermediate 1
- `FieldVsMethod.java` - Intermediate 2
- `Payment.java`, `CardPayment.java`, `MobileMoneyPayment.java`, `PaymentProcessorV1.java`, `PaymentProcessorV2.java`, `PaymentDemo.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java PrintOverload
java AnimalDemo
java PayrollDemo
java FieldVsMethod
java PaymentDemo
```

## Answers
**Basic 1 - Overloading**
- Four `print` methods: `int`, `double`, `String`, `int[]`.
- The compiler picks the version from the argument types at COMPILE time.
- `print('A')` uses the `int` version (char widens to int, prints 65).
- `print(10L)` uses the `double` version (long widens to double).

**Basic 2 - Animal[]**
- `Animal[]` holds a Cat, a Cow, a Duck and a plain Animal.
- One loop calls `a.sound()` on each; the right version runs for each object.
- This is dynamic dispatch (overriding): chosen at RUNTIME from the real object type.

**Intermediate 1 - Payroll with Intern**
- `Intern extends Employee` and overrides `calculatePay()` (stipend capped at 800).
- The payroll loop is written against `Employee` only, so it did not change at all.
- New subclasses plug in without editing existing code.

**Intermediate 2 - Field vs method through a superclass reference**
- `Parent p = new Child();`
- `p.who()` prints "Child method": methods are chosen by the real object (runtime).
- `p.name` prints "Parent field": fields are chosen by the reference type (compile time).
- Fields are hidden, not overridden, so they have no polymorphism.
- `((Child) p).name` after a cast gives "Child field".
- Lesson: expose data through methods (getters), not fields, when subclasses differ.

**Challenge - PaymentProcessor, two designs**
- V1: `pay(Payment p)` uses `instanceof CardPayment c` / `instanceof MobileMoneyPayment m` pattern matching.
- V2: `pay(Payment p)` just calls `p.process()`; each payment class knows how to process itself.
- V1 pros: all logic in one place, easy to read for two types.
- V1 cons: every new payment type means editing the processor, and a forgotten branch only fails at runtime.
- V2 pros: a new type is a new class and nothing else changes (open/closed principle).
- V2 cons: logic is spread across classes, and the payment classes now depend on how processing is done.
- Conclusion: V2 scales better; V1 is acceptable for small, fixed sets of types.
