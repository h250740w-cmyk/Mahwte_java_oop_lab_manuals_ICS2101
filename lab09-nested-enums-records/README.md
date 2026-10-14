# Lab 9: Nested Types, Enums, Records and the Object Contract

## Files
- `Level.java` - Basic 1
- `RecordDemo.java` - Basic 2
- `Book.java`, `BookDemo.java` - Intermediate 1
- `LinkedList.java` - Intermediate 2
- `Coin.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java Level
java RecordDemo
java BookDemo
java LinkedList
java Coin
```

## Answers
**Basic 1 - enum Level**
- `enum Level { LOW, MEDIUM, HIGH }` is a fixed set of constants.
- An arrow `switch` expression returns advice per constant.
- The compiler checks every case is covered (no `default` needed).

**Basic 2 - record Student(String name, int age)**
- One line generates the constructor, accessors `name()` and `age()`, `equals`, `hashCode` and `toString`.
- Two records with equal values are `equals` (true) but not `==` (false).
- Equal records have equal hash codes.
- Records are immutable: fields are final.

**Intermediate 1 - Book equals and hashCode**
- Equality is by ISBN only.
- `equals` uses `instanceof` pattern matching and compares ISBNs.
- `hashCode` uses `Objects.hash(isbn)`.
- Contract: equal objects MUST return equal hash codes, so both methods use the same field.
- `HashSet.add` returns `false` for the second Book with the same ISBN, so the set size stays 2.
- Without `hashCode`, the duplicate could land in a different bucket and be accepted.

**Intermediate 2 - Linked list with nested types**
- `Node` is `private static`: it needs no reference to a list object.
- `ListIterator` is an inner (non-static) class: it reads the outer list's `head` directly.
- `LinkedList<T> implements Iterable<T>`, which is what allows `for (String s : list)`.
- The for-each loop calls `iterator()`, then `hasNext()` and `next()`.

**Challenge - enum Coin**
- Enum with a field: `PENNY(1)`, `NICKEL(5)`, `DIME(10)`, `QUARTER(25)`, a constructor and `getCents()`.
- `makeChange(amount)` takes the largest coin first (greedy) and returns an `EnumMap<Coin, Integer>`.
- Greedy is optimal for this coin set but not for every set (coins 1, 3, 4 and amount 6: greedy uses 3 coins, best is 2).
- Example: 99 cents = 3 quarters, 2 dimes, 4 pennies (9 coins).
