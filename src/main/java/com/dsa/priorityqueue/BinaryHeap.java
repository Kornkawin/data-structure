package com.dsa.priorityqueue;

import java.util.NoSuchElementException;

public class BinaryHeap implements PriorityQueue {

    private Object[] elements;
    private int size;

    public BinaryHeap(int cap) {
        elements = new Object[cap];
        size = 0;
    }

    // Time: O(n log n)
    // Too way slow
//    public BinaryHeap(Object[] arr) {
//        for(Object e : arr) {
//            offer(e);
//        }
//    }

    // Time: O(n) = O(n) + O(n)
    public BinaryHeap(Object[] arr) {
        // O(n)
        elements = new Object[arr.length];
        System.arraycopy(arr, 0, elements, 0, arr.length);
        size = arr.length;
        // Math Proof: O(n)
        for (int i=size-1; i>=0; i--) fixDown(i);
    }


    // Time: O(h) = O(log n)
    // because h = height of tree = floor(log2(n))
    @Override
    public void offer(Object value) {
        ensureCapacity(size+1);
        elements[size] = value;
        fixUp(size++);
    }

    private void ensureCapacity(int newSize) {
        if (newSize > elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    // Time: O(h) = O(log n)
    // because h = height of tree = floor(log2(n))
    protected void fixUp(int childIndex) {
        while(childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            Comparable<Object> child = (Comparable) elements[childIndex];
            Comparable<Object> parent = (Comparable) elements[parentIndex];
            if ( child.compareTo(parent) <= 0 )
                // child meet max-heap condition:
                // child <= parent
                break;
            // swap value then move childIndex
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
        }
    }

    protected void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    // Time: O(h) = O(log n)
    // because h = height of tree = floor(log2(n))
    @Override
    public Object poll() {
        // return root value
        // move last node (the most bottom-right leaf node) to root
        // then, fixDown
        Object max = peek();
        elements[0] = elements[--size];
        elements[size] = null;
        if (size > 1) fixDown(0);
        return max;
    }

    // Time: O(h) = O(log n)
    // because h = height of tree = floor(log2(n))
    protected void fixDown(int parentIndex) {
        int childIndex = parentIndex * 2 + 1;
        while(childIndex < size) {
            // find the max child
            if (childIndex + 1 < size) {
                Comparable<Object> left = (Comparable) elements[childIndex];
                Comparable<Object> right = (Comparable) elements[childIndex+1];
                if (right.compareTo(left) > 0) childIndex++;
            }
            // compare parent with max child
            Comparable<Object> parent = (Comparable) elements[parentIndex];
            Comparable<Object> child = (Comparable) elements[childIndex];
            if ( child.compareTo(parent) <= 0 )
                // child meet max-heap condition:
                // child <= parent
                break;
            // swap value then move child and parent index
            swap(childIndex, parentIndex);
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
    }

    // Time: O(1)
    @Override
    public Object peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return elements[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Object getElement(int index) {
        return elements[index];
    }

    // Time: O(n log n) = O(n) + O(n log n)
    // Static method implementation
    public static void heapSort(Object[] objects) {
        BinaryHeap heap = new BinaryHeap(0);
        heap.elements = objects;
        heap.size = objects.length;
        // O(n)
        for (int i=heap.size-1; i>=0; i--) heap.fixDown(i);
        // O(n log n)
        for (int i=heap.size-1; i>=0; i--) {
            objects[i] = heap.poll();
        }
    }
}
