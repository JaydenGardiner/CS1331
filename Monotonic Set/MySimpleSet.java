/**
 * MySimpleSet is an implementation of Monotonic Set using an ArrayList.
 * The set is always non-decreasing because there is no remove method to remove
 * items from the set, and the set does not always necessarily increase in size
 * when an item is added because duplicates are not allowed.
 *
 * @author Jayden Gardiner
 * @version 1.0 3/24/2014
 */

import java.util.ArrayList;
import java.util.Iterator;

public class MySimpleSet<E> implements MonotonicSet<E> {

    private ArrayList<E> list;

    /**
     * Constructs MySimpleSet creating an ArrayList object called list.
     *
     */
    public MySimpleSet() {
        list = new ArrayList<E>();
    }

    /**
     * Adds non-duplicate elements to the ArrayList list.
     *
     * @param The element possibly being added to the ArrayList.
     */
    public void add(E element) {
        if (list.isEmpty()) {
            list.add(element);
        } else if (!list.contains(element)) {
            list.add(element);
        }
    }

    /**
     * Finds the size of the list.
     *
     * @return The size of the list.
     */

    public int size() {
        return list.size();
    }

    /**
     * Returns an iterator over a set of elements of type E.
     *
     * @return An iterator for the list object.
     */
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
     * Returns a string representation of the ArrayList list.
     *
     * @return A string representation of the ArrayList list.
     */
    public String toString() {
        return "" + this.list;
    }
}