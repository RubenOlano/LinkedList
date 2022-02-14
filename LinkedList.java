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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null && i < index) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public E valueNFromEnd(int n) throws IndexOutOfBoundsException {
        int size = getSize();
        if (size <= n)
            throw new IndexOutOfBoundsException("Index " + n + " is out of bounds");
        Node<E> temp = head;
        for (int i = 0; i < size - 1 - n; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> curr = head;
        Node<E> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
        list.delete(2);
        list.print();
        System.out.printf("Size of %d\n", list.getSize());
        System.out.println(list.valueNFromEnd(2));
        System.out.println(list.isEmpty());
        list.reverse();
        list.print();
    }
}