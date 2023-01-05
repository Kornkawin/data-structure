package com.dsa.priorityqueue;

import java.util.NoSuchElementException;

public class BinaryMinHeap implements PriorityQueue {

    private Object[] elements;
    private int size;

    public BinaryMinHeap(int cap) {
        elements = new Object[cap];
        size = 0;
    }

    public BinaryMinHeap(Object[] arr) {
        elements = new Object[arr.length];
        System.arraycopy(arr, 0, elements, 0, arr.length);
        size = arr.length;
        for (int i=size-1; i>=0; i--) fixDown(i);
    }

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

    protected void fixUp(int childIndex) {
        while(childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            Comparable<Object> child = (Comparable) elements[childIndex];
            Comparable<Object> parent = (Comparable) elements[parentIndex];
            if ( child.compareTo(parent) >= 0 )
                // child meet min-heap condition:
                // child >= parent
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

    @Override
    public Object poll() {
        Object min = peek();
        elements[0] = elements[--size];
        elements[size] = null;
        fixDown(0);
        return min;
    }

    protected void fixDown(int parentIndex) {
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < size) {
            // find the min child
            if (childIndex + 1 < size) {
                Comparable<Object> leftChild = (Comparable) elements[childIndex];
                Comparable<Object> rightChild = (Comparable) elements[childIndex + 1];
                if (rightChild.compareTo(leftChild) < 0) childIndex++;
            }
            // compare min child with parent
            Comparable<Object> parent = (Comparable) elements[parentIndex];
            Comparable<Object> child = (Comparable) elements[childIndex];
            if ( child.compareTo(parent) >= 0 )
                // child meet min-heap condition:
                // child >= parent
                break;
            // swap value then move parent and child index
            swap(childIndex, parentIndex);
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
    }

    @Override
    public Object peek() {
        if (isEmpty()) throw new NoSuchElementException();
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
}
