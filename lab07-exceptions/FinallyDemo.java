/**
 * Lab 7 - Challenge: predict the output.
 *
 * Prediction: "in try", then "in finally", then "result = 1".
 * Why: return in try does not leave the method immediately. Java computes the return
 * value (1), stores it, runs the finally block, and only then returns. finally runs
 * whether the try block ends normally, by return, break/continue, or by an exception.
 * (It is skipped only if the JVM stops, e.g. System.exit or a crash.)
 *
 * Note: the second method shows a trap. A return inside finally OVERRIDES the try's return.
 */
public class FinallyDemo {
    static int test() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");
        }
    }

    @SuppressWarnings("finally")
    static int trap() {
        try {
            return 1;
        } finally {
            return 2;          // overrides the earlier return - avoid this in real code
        }
    }

    public static void main(String[] args) {
        System.out.println("result = " + test());
        System.out.println("trap result = " + trap());
    }
}
