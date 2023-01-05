package com.dsa.priorityqueue.usecase.minheap;

import com.dsa.priorityqueue.BinaryHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] input = {2,2,3,1,0};
        int[] sol = heapSort(input);
        for (int i: sol) System.out.print(i + " ");
        System.out.println();

        Integer[] input2 = {2,2,3,1,0};
        BinaryHeap.heapSort(input2);
        for (int i: input2) System.out.print(i + " ");
    }

    // Time O(n log n) = O(n) + O(n log n)
    private static int[] heapSort(int[] nums) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        // O(n)
        for(int num : nums) pQueue.offer(num);
        // O(n log n)
        for(int k = nums.length-1; k>= 0; k--) nums[k] = pQueue.poll();
        return nums;
    }
}
