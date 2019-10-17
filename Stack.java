import java.util.Iterator;
import java.util.NoSuchElementException;
//by: Isabella Rolfe
public class Stack<Item> implements Iterable<Item> {
    private Node top;
    private Node next;
    private int size;

    public class Node {
        public Item item;
        public Node next;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = size;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            //not supported
        }

        public Item next() {
            throw new NoSuchElementException("Stack is empty!");
        }
    }

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void Push(Item item) {
        if (top == null) {
            top = new Node();
            top.item = item;
        } else {
            Node temp = top;
            top = new Node();
            top.next = temp;
            top.item=item;
        }
        size++;
    }

    public Node Pop() {
        Node temp = top;
        if (top != null) {
            top = top.next;
        }
        size--;
        return temp;
    }

    public int size() {
        return size;
    }
}





