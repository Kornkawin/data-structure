package com.dsa.array;

/**
 * Implementation of an integer only array
 * which can outperform Java's ArrayList by about a factor of 10-15x! Enjoy!
 */
public class IntArray implements Iterable<Integer> {

    private static final int DEFAULT_CAP = 1 << 3;
    private int[] arr;
    private int len = 0;
    private int capacity = 0;

    public IntArray() {
        this(DEFAULT_CAP);
    }

    public IntArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    // Given an array make it a new dynamic array!
    public IntArray(int[] array) {
        if (array == null) throw new IllegalArgumentException("Array cannot be null");
        arr = java.util.Arrays.copyOf(array, array.length);
        capacity = len = array.length;
    }

    public int getCapacity() {
        // for testing purposes
        return capacity;
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public void add(int value) {
        if (len + 1 > capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            arr = java.util.Arrays.copyOf(arr, capacity);
        }
        arr[len++] = value;
    }

    /**
     * Reference:
     * public static void arraycopy(Object source_arr, int sourcePos,
     *                             Object dest_arr, int destPos, int len)
     * Parameters :
     * source_arr : array to be copied from
     * sourcePos : starting position in source array from where to copy
     * dest_arr : array to be copied in
     * destPos : starting position in destination array, where to copy in
     * len : total no. of components to be copied.
     *
     */
    public void removeAt(int rm_index) {
        // Time: O(n)
        int copiedLength = len-rm_index;
        System.arraycopy(
                arr, rm_index+1,
                arr, rm_index,
                copiedLength
        );
        --len;
    }

    public boolean remove(int elem) {
        // Time: O(n)
        for (int i = 0; i < len; i++) {
            if (arr[i] == elem) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public void reverse() {
        for (int i = 0; i < len / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[len-1 - i];
            arr[len-1 - i] = tmp;
        }
    }

    // Perform a binary search on this array to find an element in O(log(n)) time
    // Make sure this array is sorted before call method! Returns a value < 0 if item is not found
    public int binarySearch(int key) {
        int index = java.util.Arrays.binarySearch(arr, 0, len, key);
        return index;
    }

    // Iterator is still fast but not as fast as iterative for loop
    @Override
    public java.util.Iterator<Integer> iterator() {
        return new java.util.Iterator<>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public Integer next() {
                return arr[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
            return sb.append(arr[len - 1] + "]").toString();
        }
    }
}


