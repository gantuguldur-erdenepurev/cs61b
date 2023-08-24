
public class ArrayDeque<T>{
    /** Creates an empty list. */
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;

        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextLast, a, nextLast + size, size - nextLast);
        items = a;
    }

    private void downsize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextFirst + 1, a, (nextFirst + 1) - items.length/2, items.length - (nextFirst + 1));
        items = a;
    }

    /** Inserts X into the front of the conceptual deque. */
    public void addFirst(T x){
        if (size == items.length){
            nextFirst += items.length;
            resize(size * 2);
        }else if(nextFirst == -1){
            nextFirst = items.length - 1;
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst -= 1;
    }

    /** Inserts X into the back of the conceptual deque. */
    public void addLast(T x) {
        if (size == items.length){
            nextFirst += items.length;
           resize(size * 2);

        }else if(nextLast == items.length){
            nextLast = 0;
        }
        items[nextLast] = x;
        size += 1;
        nextLast += 1;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /** Returns the number of items in the ArrayDeque. */
    public int size() {
        return size;
    }

    public void printDeque(){
        int s = size;
        int index = nextFirst + 1;
        while (s > 0){
            if (index > items.length - 1){
                index = 0;
            }
            System.out.print(items[index] + " ");
            index += 1;
            s -= 1;
        }
        System.out.println();
    }

    /** Deletes item from the front of the ArrayDeque list and
     * returns deleted item. */
    public T removeFirst(){
        T x = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size -= 1;
        double ratio = (double)size/items.length;
        if(items.length >= 16 && ratio < 0.25){
            downsize(items.length/2);
            nextFirst -= items.length;
        }
        return x;
    }


    /** Deletes item from back of the ArrayDeque list and
     * returns deleted item. */
    public T removeLast(){
        T x = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        size -= 1;
        double ratio = (double)size/items.length;
        if (items.length >= 16 && ratio < 0.25){
            downsize(items.length/2);
            nextFirst -= items.length;
        }
        return x;
    }


    /** Gets the ith item in the list (0 is the front). */
    public T get(int index) {
        if (index >= this.size()){
            return null;
        }
        index += (nextFirst + 1);
        if (index >= items.length) {
            index -= items.length;
        }
        return items[index];
    }


    private static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        ArrayDeque L = new ArrayDeque();
        System.out.println(L.isEmpty());
        L.addFirst(5);
        System.out.println(L.isEmpty());
        L.addFirst(10);
        L.addFirst(15);
        L.addFirst(20);
        L.addLast(25);
        L.addFirst(30);
        System.out.println(L.removeFirst());
        L.addLast(35);
        L.addFirst(40);

        L.addFirst(50);
        L.printDeque();
        System.out.println(L.get(7));
        L.addFirst(55);

        System.out.println(L.removeLast());
        L.addFirst(60);
        L.addLast(65);
        L.printDeque();
        System.out.println(L.size());
        System.out.println(L.get(10));
        L.addFirst(23);
        System.out.println(L.removeFirst());
        L.addFirst(24);
        System.out.println(L.size());
        L.addLast(34);
        L.addLast(36);

        L.addFirst(65);
        System.out.println(L.removeLast());
        L.addFirst(12);
        L.addFirst(11);
        L.addLast(13);
        L.addFirst(60);
        L.addLast(65);
        L.addFirst(23);
        L.printDeque();
        System.out.println(L.get(19));
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();

        L.removeFirst();
        L.removeFirst();
        L.removeLast();
        L.removeLast();

        L.removeLast();
        L.removeLast();
        L.removeLast();
        System.out.println(L.removeFirst());
        System.out.println(L.removeFirst());
        L.addFirst(25);
        L.addLast(14);

        L.addFirst(23);
        L.removeLast();
        L.addFirst(24);


    }
}