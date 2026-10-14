public class FlyDemo {
    public static void main(String[] args) {
        // Bird and Aeroplane share NO superclass, yet both can be used as Flyable
        Flyable[] things = { new Bird(), new Aeroplane() };
        for (Flyable f : things) f.fly();
    }
}
