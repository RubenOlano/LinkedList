class LinkedList<E> {
    LinkedList<E> next;
    E elem;

    public LinkedList(E elem) {
        next = null;
        this.elem = elem;
    }

    public LinkedList() {
        this(null);
    }

    public boolean isEmpty() {
        return next == null;
    }

    public int getSize() {
        int size = 0;
        LinkedList<E> head = this;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public E valueAt(int index) throws ArrayIndexOutOfBoundsException {
        int i = 0;
        LinkedList<E> head = this;
        while (head.next != null) {
            if (i >= index) {
                throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of range");
            }
            if (i == index - 1)
                return head.elem;
            i++;
            head = head.next;
        }
        return null;
    }

}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.printf("Size of %d", list.getSize());
    }
}