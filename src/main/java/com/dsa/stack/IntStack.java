package com.dsa.stack;

/**
 * This file contains an implementation of an integer only stack which is extremely quick and
 * lightweight. In terms of performance it can outperform java.util.ArrayDeque (Java's fastest stack
 * implementation) by a factor of 50! See the benchmark test for proof. However, the downside
 * is you need to know an upper bound on the number of elements that will be inside the stack at any
 * given time for it to work correctly.
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 */
public class IntStack implements Stack<Integer> {
    private int[] arr;
    private int pos = 0;

    public IntStack(int maxSize) {
        arr = new int[maxSize];
    }

    // return number of elements inside stack
    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isEmpty() {
        return pos == 0;
    }

    @Override
    public void push(Integer value) {
        arr[pos++] = value;
    }

    @Override
    public Integer pop() {
        return arr[--pos];
    }

    @Override
    public Integer peek() {
        return arr[pos - 1];
    }
}
