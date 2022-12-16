package com.dsa.queue;

/**
 * This file contains an implementation of an integer only queue which is extremely quick and
 * lightweight. In terms of performance it can outperform java.util.ArrayDeque (Java's fastest queue
 * implementation) by a factor of 40+! See the benchmark test for proof. However, the downside
 * is you need to know an upper bound on the number of elements that will be inside the queue at any
 * given time for this queue to work.
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com, liujingkun, liujkon@gmail.com
 */
public class IntQueue implements Queue<Integer> {
    private int[] data;
    private int front, end;
    private int size;

    public IntQueue(int maxSize) {
        front = end = size = 0;
        data = new int[maxSize];
    }

    // Add an element to the queue
    @Override
    public void offer(Integer value) {
        if (isFull()) throw new RuntimeException("Queue Capacity too small!");
        data[end++] = value;
        size++;
        end = end % data.length;
    }

    // Make sure you check is the queue is not empty before calling poll!
    @Override
    public Integer poll() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        --size;
        front = front % data.length;
        return data[front++];
    }

    @Override
    public Integer peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        front = front % data.length;
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
