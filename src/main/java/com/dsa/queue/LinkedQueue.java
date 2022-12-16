package com.dsa.queue;

public class LinkedQueue<T> implements Iterable<T>, Queue<T> {

    private java.util.LinkedList<T> list = new java.util.LinkedList<>();

    public LinkedQueue() {
    }

    public LinkedQueue(T firstElement) {
        offer(firstElement);
    }

    @Override
    public void offer(T value) {
        list.addLast(value);
    }

    @Override
    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}
