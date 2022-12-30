package com.dsa.priorityqueue;

import com.dsa.queue.Queue;

public interface PriorityQueue extends Queue {
    public Object poll();
    public Object peek();
}
