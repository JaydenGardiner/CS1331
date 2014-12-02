/**
 * Set uses an array.
 *
 * @author Jayden Gardiner
 * @version 1.0 4/2/2014
 */

import java.lang.reflect.Array;

public class Set<T extends Comparable<T>> {

    /**
     * DO NOT MODIFY
     */
    private T[] sortedArray;

    /**
     * DO NOT MODIFY
     */
    private Class<T> type;

    /**
     * DO NOT MODIFY
     */
    private static final int INITIAL_SIZE = 10;

    private int size;
    private T[] backingArray;

    /**
     * Creates a Set with a backing array.
     *
     * @param type  Type of object
     * @param initialSize  The initial size of the array
     */
    public Set(Class<T> type, int initialSize) {
        this.type = type;
        this.size = 0;
        this.backingArray = createArray(initialSize);
    }

    /**
     * Creates a Set.
     *
     * @param type Type of object
     */
    public Set(Class<T> type) {
        this(type, INITIAL_SIZE);
    }

    /**
     * Add the specified entry into the backing array and return true.
     * If the entry already exists, don't add and return false.
     * throw IllegalArgumentException if input is null.
     * @param entry The object in the array which may be added
     * @return boolean - true if adds entry, false if duplicate entry
     */
    public boolean add(T entry) {
        if (null == entry) {
            throw new IllegalArgumentException();
        }

        boolean isFull = true;
        for (int x = 0; x < backingArray.length; x++) {
            if (backingArray[x] == null) {
                isFull = false;
            }
        }
        if (isFull) {
            int i = 0;
            T[] newArray = createArray(2 * backingArray.length);
            for (T element: backingArray) {
                newArray[i] = element;
                i++;
            }
            backingArray = newArray;
            isFull = false;
        }

        if (!contains(entry)) {
            backingArray[size] = entry;
            size++;
            return true;
        }
        return false;

    }

    /**
     * Remove and return the specified entry from the backing array.
     * If the entry doesn't exist, return null.
     * throw IllegalArgumentException if input is null.
     * @param entry The entry in the array which may be removed
     * @return the entry removed from the array
     */
    public T remove(Object entry) {
        if (null == entry) {
            throw new IllegalArgumentException();
        }
        if (contains((T) entry)) {
            for (int x = 0; x < backingArray.length; x++) {
                if (backingArray[x].equals(entry)) {
                    T removed = backingArray[x];
                    int i = 0;
                    T[] newArray = createArray(backingArray.length);
                    for (T element: backingArray) {
                        if (removed != element) {
                            newArray[i] = element;
                            i++;
                        }
                    }
                    backingArray = newArray;
                    size--;
                    return removed;
                }
            }
        }
        return null;
    }

    /**
     * Remove and return the entry at specified index from the backing array.
     * If the index is negative or greater than size, return null.
     * @param index The position of the object in the array which may be removed
     * @return the entry removed from the array
     */
    public T remove(int index) {
        if ((index >= 0) && (index < size)) {
            T removed = backingArray[index];
            int i = 0;
            T[] newArray = createArray(backingArray.length);
            for (T element: backingArray) {
                if (removed != element) {
                    newArray[i] = element;
                    i++;
                }
            }
            backingArray = newArray;
            size--;
            return removed;
        }
        return null;
    }

    /**
     * Return true if backing array contains the specified entry.
     * Return false otherwise.
     * throw IllegalArgumentException if input is null.
     * @param entry The object checked to see if is contained by the array
     * @return boolean, true if array contains entry, false otherwise
     */
    public boolean contains(T entry) {
        if (null == entry) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            if (backingArray[i].equals(entry)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a COPY of the backing array.
     * Don't return the backing array.
     * @return newArray A copy of the backing array
     */
    public T[] toArray() {
        int i = 0;
        T[] newArray = createArray(backingArray.length);
        for (T element: backingArray) {
            newArray[i] = element;
            i++;
        }
        return newArray;
    }

    /**
     * Return true if the backing array is empty.
     * Return false otherwise.
     * @return boolean, true is array is empty, false otherwise
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Reset the backing array to an empty array
     * of length INITIAL_SIZE
     */
    public void clear() {
        T[] newArray = createArray(INITIAL_SIZE);
    }

    /**
     * Return the number of non-null objects in the backing array.
     * @return size The size of the array
     */
    public int size() {
        for (int x = 0; x < backingArray.length; x++) {
            if (null != backingArray[x]) {
                size++;
            }
        }
        return size;
    }

    /**
     * Return string representation of the backing array.
     * Please check the pdf for correct format.
     * @return returnString Returns a string representation of the backing array
     */
    public String toString() {
        String returnString = "The gradebook:\n";
        for (int x = 0; x < backingArray.length; x++) {
            if (null != backingArray[x]) {
                returnString = returnString + backingArray[x].toString() + "\n";
            }
        }
        return returnString;
    }

    // DO NOT MODIFY CODE BELOW

    /**
     * IMPORTANT!!
     * Return a generics array of input type and has length
     * equivalent to input size. Use this method to create
     * any new arrays in this class.
     * @param size
     * @return
     */
    @SuppressWarnings("unchecked")
    private T[] createArray(int size) {
        return (T[]) Array.newInstance(type, size);
    }

    /**
     * Return the sorted version of the backing array.
     * @return (T[]) the sorted array
     */
    public T[] sort() {
        if (size == 0) {
            return null;
        }
        sortedArray = createArray(size);
        for (int i = 0; i < size; i++) {
            sortedArray[i] = backingArray[i];
        }
        sort(0, size - 1);
        return sortedArray;
    }

    /**
     * An awesome sorting technique.
     * Can you guess what sort this is?
     * A picture of Aaron is the prize
     * @param start (int)
     * @param end (int)
     */
    private void sort(int start, int end) {
        int firstHalf = start;
        int lastHalf = end;
        int pivotIndex = start + (int) (Math.random() * (end - start));
        T pivot = sortedArray[pivotIndex];
        while (firstHalf <= lastHalf) {
            while (sortedArray[firstHalf].compareTo(pivot) > 0) {
                firstHalf++;
            }
            while (sortedArray[lastHalf].compareTo(pivot) < 0) {
                lastHalf--;
            }
            if (firstHalf <= lastHalf) {
                T temp = sortedArray[firstHalf];
                sortedArray[firstHalf] = sortedArray[lastHalf];
                sortedArray[lastHalf] = temp;
                firstHalf++;
                lastHalf--;
            }
        }
        if (start < lastHalf) {
            sort(start, firstHalf);
        }
        if (firstHalf < end) {
            sort(firstHalf, end);
        }
    }
}