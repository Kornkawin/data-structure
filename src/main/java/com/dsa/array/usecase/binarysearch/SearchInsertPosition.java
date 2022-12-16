package com.dsa.array.usecase.binarysearch;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        // int[] input = {1,1,2};
        int target = 2;
        // int sol = searchInsertPositionPointer(input, target);
        int sol = searchInsertPosition(input, target);
        System.out.println(Arrays.toString(input));
        System.out.println("Ans: "+sol);
    }

    // Time: O(n)
    private static int searchInsertPositionPointer(int[] nums, int target) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < target){
                pointer++;
            }
        }
        return pointer;
    }

    // Time: O(log n)
    // Binary Search
    private static int searchInsertPosition(int[] nums, int target) {
        int pivot, left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return left;
    }
}
