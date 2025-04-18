public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public void add(T item) {
        Node newNode = new Node(item);
        if (head == null) head = newNode;
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public T remove(int index) {
        if (index == 0) {
            T removed = head.data;
            head = head.next;
            size--;
            return removed;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;
        T removed = current.next.data;
        current.next = current.next.next;
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}