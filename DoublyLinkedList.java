public class DoublyLinkedList<T> {
    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addFront(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public T find(T value) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(value)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public T popBack() {
        if (head == null)
            return null;
        if (head == tail) {
            T val = head.data;
            head = null;
            tail = null;
            return val;
        }
        T val = tail.data;
        tail = tail.prev;
        return val;
    }

    public T popFront() {
        if (head == null)
            return null;
        if (head == tail) {
            T val = head.data;
            head = null;
            tail = null;
            return val;
        }
        T val = head.data;
        head = head.next;
        return val;
    }
}
