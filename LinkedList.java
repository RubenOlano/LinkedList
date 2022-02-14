class LinkedList<E> {
    Node<E> head;

    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public int getSize() {
        Node<E> temp = this.head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushFront(E elem) {
        if (head == null) {
            head = new Node<E>(elem);
            return;
        }
        Node<E> temp = new Node<E>(elem);
        temp.next = head;
        head = temp;
    }

    public E popFront() {
        Node<E> temp = head.next;
        E val = temp.data;
        head = temp;
        return val;
    }

    public void pushBack(E elem) {
        Node<E> tail = head;
        while (tail != null) {
            tail = tail.next;
        }
        tail = new Node<E>(elem);
    }

    public E popBack() {
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        E val = tail.next.data;
        tail.next = null;
        return val;
    }

    public E front() {
        return head.data;
    }

    public E back() {
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail.data;
    }

    public void insert(int index, E elem) throws IndexOutOfBoundsException {
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null && i < index) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            temp = temp.next;
        }
        Node<E> newNode = new Node<E>(elem);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushFront(2);
        list.pushFront(3);
        list.pushFront(5);
        System.out.printf("Size of %d\n", list.getSize());
        list.insert(2, 1);
        list.print();
        System.out.printf("Size of %d\n", list.getSize());

        System.out.println(list.isEmpty());

    }
}