package com.dsa.priorityqueue.usecase.minheap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class ThirdDistinctMaxNumber {

    public static void main(String[] args) {
        int[] input = {2,2,3,1};
        int sol = thirdMax(input);
        System.out.println(sol);
    }

    private static int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashSet<Integer> taken = new HashSet<>();

        // Queueing
        for (int num: nums) {
            if (taken.contains(num)) continue;

            if (minHeap.size() == 3){
                if (minHeap.peek() < num) {
                    taken.remove(minHeap.poll());
                    minHeap.add(num);
                    taken.add(num);
                }
            } else {
                taken.add(num);
                minHeap.add(num);
            }
        }

        // return
        if (minHeap.size() == 1) return minHeap.peek();
        else if (minHeap.size() == 2) return Math.max(minHeap.poll(), minHeap.peek());
        else return minHeap.peek();
    }
}


