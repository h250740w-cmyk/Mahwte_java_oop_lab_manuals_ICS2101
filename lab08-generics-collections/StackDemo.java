public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        System.out.println("peek = " + numbers.peek());
        int top = numbers.pop();                 // no cast needed: type safety from generics
        System.out.println("popped " + top + ", size now " + numbers.size());

        Stack<String> words = new Stack<>();
        words.push("one");
        words.push("two");
        while (!words.isEmpty()) System.out.println("pop: " + words.pop());

        // numbers.push("text");   // compile error: Stack<Integer> only accepts Integer
        try {
            words.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
