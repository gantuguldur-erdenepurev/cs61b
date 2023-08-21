//         0 1  2 3 4 5 6 7
// items: [4 2 -1 3 0 0 0 0 ...]
// size: 4

/* Invariants (things that are always true about our data structure)
addLast: the next item we want to add, will go into position size.
getLast: the item we want to return is in position size - 1
size: the number of items in the list should be size.
 */
public class ArrayDeque<T>{
    /** Creates an empty list. */
    private T[] items;
    private int size;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length){
           resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        ArrayDeque L = new ArrayDeque();
        L.addLast(5);
        L.addLast(10);
        L.addLast(15);

    }
}