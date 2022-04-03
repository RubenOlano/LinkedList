import java.util.Iterator;

class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        head = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void pushFront(T elem) {
        if (head == null) {
            head = new Node<T>(elem);
            return;
        }
        size++;
        Node<T> temp = new Node<T>(elem);
        temp.next = head;
        head = temp;
    }

    public T popFront() {
        Node<T> temp = head.next;
        T val = temp.data;
        head = temp;
        size--;
        return val;
    }

    public void pushBack(T elem) {
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node<T>(elem);
        size++;
    }

    public T popBack() {
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        T val = tail.next.data;
        tail.next = null;
        size--;
        return val;
    }

    public T front() {
        return head.data;
    }

    public T back() {
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail.data;
    }

    public void insert(int index, T elem) throws IndexOutOfBoundsException {
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null && i < index) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            temp = temp.next;
        }
        size++;
        Node<T> newNode = new Node<T>(elem);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null && i < index) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public T valueNFromEnd(int n) throws IndexOutOfBoundsException {
        int size = getSize();
        if (size <= n)
            throw new IndexOutOfBoundsException("Index " + n + " is out of bounds");
        Node<T> temp = head;
        for (int i = 0; i < size - 1 - n; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeValue(T val) {
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T val = trav.data;
                trav = trav.next;
                return val;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> trav = head;
        sb.append("[ ");
        while (trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" ]");
        return sb.toString();
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
        System.out.println(list);
        list.delete(2);
        System.out.println(list);
        System.out.printf("Size of %d\n", list.getSize());
        System.out.println(list.valueNFromEnd(2));
        System.out.println(list.isEmpty());
        System.out.println(list);

        list.pushBack(2);
        list.pushBack(2);
        list.reverse();
        System.out.println(list);

        list.removeValue(2);
        System.out.println(list);

    }
}