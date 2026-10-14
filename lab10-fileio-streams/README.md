# Lab 10: File I/O, Lambdas and Streams

## Files
- `SaveAndRead.java` - Basic 1 (keyboard input)
- `RemoveEvens.java` - Basic 2
- `FileStats.java` - Intermediate 1
- `AboveAverage.java` - Intermediate 2
- `GroupLearners.java` + `learners.csv` - Challenge
- `output.txt`

## Run
```
javac *.java
java SaveAndRead
java RemoveEvens
java FileStats              # or: java FileStats yourfile.txt
java AboveAverage
java GroupLearners          # reads learners.csv, writes report-A/B/C.txt
```

## Answers
**Basic 1 - Save and read back five lines**
- Five lines are read with `Scanner`, written with `Files.write(path, lines)`, then read with `Files.readAllLines`.
- `IOException` is caught and reported.

**Basic 2 - Predicate and removeIf**
- `Predicate<Integer> isEven = n -> n % 2 == 0;`
- `list.removeIf(isEven)` removes every element for which the predicate is true.
- Input 1..10 becomes [1, 3, 5, 7, 9].

**Intermediate 1 - Lines, words, characters**
- Lines: size of `Files.readAllLines`.
- Words: trim each non-blank line and split on `\s+`.
- Characters: length of `Files.readString` (newlines are counted).
- Pass a file name as an argument; with none, a small sample file is generated.
- A missing file prints a message instead of crashing.

**Intermediate 2 - Above-average students with streams**
- Average: `mapToDouble(...).average()`.
- Then `filter(mark > average)`, `map(name)`, `sorted()`, `forEach(print)`.
- Sample data: average 69.83, so Amina, Mary and Zawadi are printed.
- The average is computed once, outside the second pipeline, so it is not recalculated per student.

**Challenge - Group learners from CSV**
- Each line `name,roll,gpa` is parsed into a `record Learner`.
- Bands: A = gpa 3.5 or more, B = 3.0 to 3.49, C = below 3.0.
- `Collectors.groupingBy(Learner::band)` builds a `Map<String, List<Learner>>`.
- One file per band: `report-A.txt`, `report-B.txt`, `report-C.txt`.
- Empty bands still get a report file (header with 0 learners).
