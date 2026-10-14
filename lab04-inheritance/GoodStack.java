import java.util.ArrayList;
import java.util.List;

/** Lab 4 - Challenge (good design): Stack that CONTAINS an ArrayList (composition). */
public class GoodStack {
    private final List<Integer> items = new ArrayList<>();   // hidden implementation detail

    public void push(int x) { items.add(x); }

    public int pop() {
        if (items.isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.remove(items.size() - 1);
    }

    public int peek() {
        if (items.isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public int size()        { return items.size(); }

    public static void main(String[] args) {
        GoodStack s = new GoodStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek = " + s.peek());
        while (!s.isEmpty()) {
            System.out.println("pop  = " + s.pop());
        }
        // s.add(0, 99);   // does not compile: only push/pop/peek/isEmpty/size are exposed
    }
}
