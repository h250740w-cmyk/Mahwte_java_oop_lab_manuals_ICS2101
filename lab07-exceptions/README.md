# Lab 7: Exception Handling

## Files
- `DivideNumbers.java` - Basic 1 (uses keyboard input)
- `ArrayAccess.java` - Basic 2
- `InvalidAgeException.java`, `AgeValidator.java` - Intermediate 1
- `InsufficientFundsException.java`, `BankAccount.java`, `BankDemo.java` - Intermediate 2
- `FinallyDemo.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java DivideNumbers
java ArrayAccess
java AgeValidator
java BankDemo
java FinallyDemo
```

## Answers
**Basic 1 - Divide two integers**
- Input is read as text and converted with `Integer.parseInt`.
- `NumberFormatException` is caught for non-numeric input.
- `ArithmeticException` is caught for division by zero.
- `finally` prints "Program finished." in every case.
- Catch the specific exceptions first; the program never crashes.

**Basic 2 - ArrayIndexOutOfBoundsException**
- `elementAt(data, index)` wraps `data[index]` in try/catch.
- On a bad index (5 or -1) it prints a message and returns -1.
- Alternative: check `index >= 0 && index < data.length` first (often better than catching).

**Intermediate 1 - InvalidAgeException (checked)**
- Extends `Exception`, so it is checked.
- `validateAge(int)` declares `throws InvalidAgeException` and throws it for ages outside 0 to 120.
- Callers must catch it or declare it, or the code will not compile.
- Valid ages 25, 0, 120 pass; -5 and 200 are rejected.

**Intermediate 2 - withdraw throws InsufficientFundsException**
- `withdraw` no longer returns a boolean; it throws a checked exception carrying the shortfall.
- Trade-offs:
  - Boolean: simple and fast, but callers can ignore it, and it cannot say why or by how much.
  - Exception: cannot be silently ignored, carries details, separates the error path from normal flow.
  - Exception cost: more try/catch code, and slower than a boolean, so use it for genuine failures.
- A balance too low is a normal business event; either design is defensible.

**Challenge - return inside try with finally**
- Output order: "in try", then "in finally", then "result = 1".
- `return 1` computes the value, then Java runs `finally`, then returns.
- `finally` runs on normal completion, return, break, continue and exceptions.
- It does NOT run only if the JVM ends (`System.exit()`, crash, power loss).
- Trap: a `return` inside `finally` overrides the try's return (the `trap()` method returns 2). Avoid this.
