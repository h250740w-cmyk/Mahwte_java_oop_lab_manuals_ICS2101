/**
 * Lab 6 - Challenge: two interfaces with the same default method.
 *
 * Rule: if a class inherits two defaults with the same signature, the compiler refuses to guess.
 * The class MUST override the method. Inside the override it can pick one version with
 * InterfaceName.super.hello(), or both, or write fresh code.
 * (A method declared in a class, or inherited from a superclass, always wins over an interface default.)
 */
public class DefaultConflict implements Hello1, Hello2 {
    @Override
    public void hello() {
        Hello1.super.hello();
        Hello2.super.hello();
        System.out.println("Hello from DefaultConflict (resolved the conflict)");
    }

    public static void main(String[] args) {
        new DefaultConflict().hello();
    }
}
