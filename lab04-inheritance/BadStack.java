import java.util.ArrayList;

/** Lab 4 - Challenge (bad design): Stack that INHERITS from ArrayList. */
public class BadStack extends ArrayList<Integer> {
    public void push(int x) { add(x); }
    public int pop()        { return remove(size() - 1); }

    public static void main(String[] args) {
        BadStack s = new BadStack();
        s.push(1);
        s.push(2);
        s.push(3);

        // The inheritance version wrongly exposes ALL ArrayList methods,
        // so callers can break the "last in, first out" rule:
        s.add(0, 99);        // insert at the bottom
        s.remove(1);         // remove from the middle
        System.out.println("Stack after illegal operations: " + s);
    }
}
