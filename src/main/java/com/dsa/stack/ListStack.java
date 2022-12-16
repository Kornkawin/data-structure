package com.dsa.stack;

public class ListStack<T> implements Iterable<T>, Stack<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<>();

    public ListStack() {
    }

    public ListStack(T firstElement) {
        push(firstElement);
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
    public void push(T elem) {
        list.addLast(elem);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return list.peekLast();
    }

    // Searches for the element starting from top of the stack
    // Returns -1 if the element is not present in the stack
    public int search(T elem) {
        return list.lastIndexOf(elem);
    }

    // Allow users to iterate through the stack using an iterator
    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}
