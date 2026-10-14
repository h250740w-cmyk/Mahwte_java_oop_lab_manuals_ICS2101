# Lab 8: Generics and Collections

## Files
- `ListStats.java` - Basic 1
- `RemoveDuplicates.java` - Basic 2
- `Stack.java`, `StackDemo.java` - Intermediate 1
- `WordFrequency.java` - Intermediate 2 (reads a paragraph from the keyboard)
- `BubbleSort.java` - Challenge
- `output.txt`

## Run
```
javac *.java
java ListStats
java RemoveDuplicates
java StackDemo
java WordFrequency
java BubbleSort
```

## Answers
**Basic 1 - ArrayList of 10 integers**
- Sum: loop adding each element (385 for the sample data).
- Maximum: `Collections.max(list)`.
- Reverse: copy the list, then `Collections.reverse(copy)`, so the original is not changed.

**Basic 2 - Remove duplicates**
- A `Set` never holds duplicates.
- `new LinkedHashSet<>(names)` removes them AND keeps the original order.
- `HashSet` would also dedupe but gives no order guarantee.

**Intermediate 1 - Generic `Stack<T>`**
- `Stack<T>` is backed by `ArrayList<T>`: `push` adds at the end, `pop` removes the last, `peek` reads it.
- `pop` and `peek` throw `IllegalStateException` when empty.
- `Stack<Integer>` and `Stack<String>` reuse one class, with compile-time type safety and no casts.
- `numbers.push("text")` on a `Stack<Integer>` does not compile.

**Intermediate 2 - Word frequency**
- Lower-case the text and split on `\W+` (anything that is not a letter or digit).
- `map.merge(word, 1, Integer::sum)` counts each word.
- Entries sorted by count descending, then alphabetically to break ties.
- If you press Enter on a blank line, a built-in sample sentence is used.

**Challenge - Generic bubble sort**
- Signature: `<T extends Comparable<T>> void bubbleSort(T[] arr)`.
- `T extends Comparable<T>` guarantees `compareTo` exists on every element.
- Works for `Integer[]` and `String[]`.
- Why `int[]` will not work:
  - Generic type parameters must be reference types (classes or interfaces).
  - `int` is a primitive, so `int[]` is not a `T[]` for any T.
  - Arrays of primitives are not auto-boxed to arrays of wrappers.
  - Fix: use `Integer[]`, or write a separate `int[]` version.
