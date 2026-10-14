/**
 * Lab 2 - Intermediate 2: predict the output, then verify.
 * Prediction:
 *   static block 1, static block 2        (once, when the class loads)
 *   then for EACH object: instance block 1, instance block 2, constructor
 */
public class InitBlocks {
    static { System.out.println("static block 1"); }
    static { System.out.println("static block 2"); }

    { System.out.println("instance block 1"); }
    { System.out.println("instance block 2"); }

    InitBlocks() { System.out.println("constructor"); }

    public static void main(String[] args) {
        System.out.println("main starts");
        new InitBlocks();
        System.out.println("--- second object ---");
        new InitBlocks();
    }
}
