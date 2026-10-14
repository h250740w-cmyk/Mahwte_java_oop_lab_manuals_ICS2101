public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] zoo = { new Cat(), new Cow(), new Duck(), new Animal() };

        // One loop, one call. Java picks the right sound() at RUNTIME (dynamic dispatch).
        for (Animal a : zoo) {
            System.out.println(a.getClass().getSimpleName() + " says " + a.sound());
        }
    }
}
