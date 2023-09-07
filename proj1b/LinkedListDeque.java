
public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        private T item;
        private StuffNode prev;
        private StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /* The addLast method takes constant time now. */
    @Override
    public void addLast(T item) {
        sentinel.prev = new StuffNode(sentinel.prev, item, null);
        sentinel.prev.next = sentinel;
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        if (sentinel.next == sentinel && sentinel.prev == sentinel) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode p = sentinel.next;
        int s = this.size();
        while (s > 0) {
            System.out.print(p.item + " ");
            p = p.next;
            s--;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T F = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return F;
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T L = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return L;
    }

    @Override
    public T get(int index) {
        if (index > this.size() - 1) {
            return null;
        }
        StuffNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    private T getRecursiveHelper(int i, StuffNode k) {
        if (i == 0) {
            return k.next.item;
        }
        return getRecursiveHelper(i - 1, k.next);
    }

    public T getRecursive(int index) {
        if (index > this.size() - 1) {
            return null;
        }
        return getRecursiveHelper(index, sentinel);
    }


    private static void main(String[] args) {
        /* Creates a list of integers */
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        System.out.println(L.isEmpty());

        L.addFirst(30);
        L.addFirst(23);
        L.addLast(35);
        L.printDeque();
        System.out.println(L.removeLast());
        L.printDeque();
        L.addFirst(10);
        L.printDeque();
        System.out.println(L.getRecursive(2));
        System.out.println(L.get(1));
        System.out.println(L.removeFirst());
        System.out.println(L.size());
        L.printDeque();


    }
}
