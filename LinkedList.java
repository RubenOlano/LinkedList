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
}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.isEmpty());
        list.pushFront(2);
        list.pushFront(3);
        list.pushFront(5);
        System.out.printf("Size of %d\n", list.getSize());
        list.popFront();
        System.out.printf("Size of %d\n", list.getSize());

        System.out.println(list.isEmpty());

    }
}