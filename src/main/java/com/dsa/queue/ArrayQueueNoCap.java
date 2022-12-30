package com.dsa.queue;

import java.util.NoSuchElementException;

public class ArrayQueueNoCap implements Queue{
    private Object[] elements;
    private int size;
    private int front;  // for pointer

    public ArrayQueueNoCap(int cap) {
        elements = new Object[cap];
        size = front = 0;
    }

    @Override
    public void offer(Object e) {
        // to ensure capacity
        if (size == elements.length) {
            Object[] a = new Object[2 * elements.length];
            for (int i=0, j=front; i<size; i++, j=(j+1)%elements.length) {
                // i for loop data
                // j for circular
                a[i] = elements[j];
            }
            front = 0;
            elements = a;
        }
        // to enqueue
        int rearIndex = (front+size) % elements.length;
        elements[rearIndex] = e;
        ++size;
    }

    @Override
    public Object poll() {
        Object e = peek();
        elements[front] = null;
        front = (front+1) % elements.length;
        --size;
        return e;
    }

    @Override
    public Object peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return elements[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
