import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Lab 9 - Intermediate 2: singly linked list.
 *  - Node is a PRIVATE STATIC nested class: it needs no reference to a list object.
 *  - ListIterator is an INNER class (non-static): it reads the outer list's 'head' directly.
 *  - Implementing Iterable<T> makes the list usable in a for-each loop.
 */
public class LinkedList<T> implements Iterable<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int size() { return size; }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;        // 'head' belongs to the OUTER object

        @Override public boolean hasNext() { return current != null; }

        @Override public T next() {
            if (current == null) throw new NoSuchElementException();
            T v = current.value;
            current = current.next;
            return v;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("alpha");
        list.add("beta");
        list.add("gamma");

        for (String s : list) {                // works because of Iterable
            System.out.println(s);
        }
        System.out.println("size = " + list.size());

        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= 5; i++) nums.add(i * i);
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("sum of squares = " + sum);
    }
}
