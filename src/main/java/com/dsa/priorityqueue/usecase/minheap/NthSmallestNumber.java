package com.dsa.priorityqueue.usecase.minheap;

import com.dsa.priorityqueue.BinaryHeap;
import com.dsa.priorityqueue.BinaryMinHeap;
import com.dsa.priorityqueue.PriorityQueue;

public class NthSmallestNumber {
    public static void main(String[] args) {
        Integer[] input = {2,4,1,7,9,5,6,8,10};
        int n = 4;
        System.out.println(findNthSmallest(input, n));
        System.out.println(findNthSmallest2(input, n));
        System.out.println(findNthSmallest3(input, n));
    }

    // Time O(n log n)
    // Sort then select
    private static Integer findNthSmallest(Integer[] input, int k) {
        BinaryHeap.heapSort(input);
        return input[k-1];
    }

    // Time O(k log n) , k<n
    // but too much memory when n is large
    private static Integer findNthSmallest2(Integer[] input, int k) {
        // use minheap and poll k times
        // O(n)
        PriorityQueue heap = new BinaryMinHeap(input);
        // O(k log n) , k<n
        for (int i = 0; i < k-1; i++) heap.poll();
        return (Integer) heap.poll();
    }

    // Time O(n log k) , k<n
    // little slower than findNthSmallest2 but using limited memory
    private static Integer findNthSmallest3(Integer[] input, int k) {
        // use maxheap to store k smallest elements
        PriorityQueue heap = new BinaryHeap(k);
        int i = 0;
        // O(n log k) , k<n
        for(; i<k; i++) heap.offer(input[i]);
        for(; i<input.length; i++) {
            if((Integer)heap.peek() > input[i]) {
                heap.poll();
                heap.offer(input[i]);
            }
        }
        return (Integer) heap.peek();
    }
}
