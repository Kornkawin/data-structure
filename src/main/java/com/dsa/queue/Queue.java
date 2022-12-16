package com.dsa.queue;

/**
 * Use Case
 * - Waiting line models
 * - Web server request management (FIFO)
 * - Breadth First Search (BFS) graph traversal
 */
public interface Queue<T> {
    // Enqueue = Adding = Offering
    public void offer(T value);
    // Dequeue = Polling
    public T poll();
    public T peek();
    public int size();
    public boolean isEmpty();
}
