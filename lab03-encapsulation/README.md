# Lab 3: Encapsulation

## Files
- `Student.java` - Basic 1 and 2
- `BankAccount.java` - Intermediate 1
- `ImmutablePerson.java` - Intermediate 2
- `Temperature.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java Student
java BankAccount
java ImmutablePerson
java Temperature
```

## Answers
**Basic 1 - Student validation**
- `name` and `marks` are `private`; access is through getters and setters.
- `setMarks` throws `IllegalArgumentException` unless 0 <= marks <= 100.
- The constructor uses the setter, so validation cannot be bypassed at creation.

**Basic 2 - getGrade()**
- A (70+), B (60-69), C (50-59), F (below 50).
- The grade is computed from `marks` each call and is NOT stored in a field.
- This avoids two values that could disagree (marks changed, grade not updated).

**Intermediate 1 - Transaction history**
- A private `List<String> history` records OPEN, DEPOSIT, WITHDRAW and FAILED WITHDRAW.
- `getHistory()` returns `List.copyOf(history)`, an unmodifiable copy.
- Returning the real list would let callers add or delete entries and falsify the history.
- Trying `copy.add(...)` throws `UnsupportedOperationException`.

**Intermediate 2 - ImmutablePerson design choices**
- `final class`: no subclass can add mutable behaviour.
- `private final` fields: each is assigned exactly once, in the constructor.
- No setters: state cannot change after construction.
- Defensive copy of the hobbies list: later changes to the caller's list do not affect the object.
- `withAge()` returns a new object instead of changing the old one.
- Benefits: safe to share between threads and safe as keys in maps and sets.

**Challenge - Temperature**
- Internal state is `kelvin` only; setters reject values below 0 K (absolute zero).
- `getCelsius()` = kelvin - 273.15; `getFahrenheit()` = Celsius x 9/5 + 32.
- Callers only use the getters, so changing the internal unit to Celsius would only change this class.
- That is the point of encapsulation: hide the representation, expose behaviour.
