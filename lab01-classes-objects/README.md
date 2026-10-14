# Lab 1: Classes and Objects

## Files
- `Car.java` - Basic 1 and 2 (Car, display(), isAntique())
- `Rectangle.java` - Intermediate 1 (area, perimeter, largest of 5)
- `RectangleAlias.java` - Intermediate 2 (reference aliasing)
- `Address.java`, `Person.java` - Challenge (Person has an Address, null handling)
- `output.txt` - real output from running every program

## Run
```
javac *.java
java Car
java Rectangle
java RectangleAlias
java Person
```

## Answers
**Basic 1 and 2 - Car**
- Fields: `brand`, `year`, `mileage`; method `display()` prints them.
- `isAntique()` returns true when current year minus `year` is more than 25.
- Three cars created in `main`; only the 1975 Ford is antique.

**Intermediate 1 - Rectangle**
- `area()` = width x height, `perimeter()` = 2 x (width + height).
- Array of 5 rectangles; loop keeps a reference to the one with the largest area.
- Largest in the sample data is 6 x 6 (area 36).

**Intermediate 2 - Prediction and explanation**
- Prediction: `r1.width` prints `20.0`, not `5.0`.
- `Rectangle r2 = r1;` copies the reference (the address), not the object.
- r1 and r2 are two names for one object on the heap.
- Changing `r2.width` therefore changes what `r1` sees.
- `r1 == r2` is `true` because `==` compares references.
- To get an independent copy you must create a new object with `new` and copy the fields.

**Challenge - Person and Address**
- A `Person` field of type `Address` holds a reference to another object.
- Chained dot: `person.address.city` goes person, then address, then city.
- If `address` was never assigned it is `null`, and `person.address.city` throws `NullPointerException`.
- Safe approach: check `if (person.address != null)` before using it.
