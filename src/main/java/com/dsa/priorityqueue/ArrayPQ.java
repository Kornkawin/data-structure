package com.dsa.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Easy but Too Slow
public class ArrayPQ implements PriorityQueue {
    private static final List<Object> list = new ArrayList<>(10);

    @Override
    public void offer(Object value) {
        list.add(value);
    }

    // Time: O(n)
    @Override
    public Object poll() {
        int max = maxIndex();
        Object result = list.get(max);
        list.remove(max);
        return result;
    }

    // Time: O(n)
    @Override
    public Object peek() {
        return list.get(maxIndex());
    }

    // Time: O(n)
    private int maxIndex() {
        if (isEmpty()) throw new NoSuchElementException();
        int max=0;
        for (int i=1; i<list.size(); i++) {
            Comparable<Object> d = (Comparable) list.get(i);
            // a negative integer, zero, or a positive integer
            // as this object (list.get(i)) is less than, equal to, or greater than
            // the specified object (list.get(max)).
            if (d.compareTo(list.get(max)) > 0) max = i;
        }
        return max;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
