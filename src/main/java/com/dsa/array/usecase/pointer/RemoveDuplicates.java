package com.dsa.array.usecase.pointer;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        // int[] input = {1,1,2};
        int sol = removeDuplicates(input);
        System.out.println("Ans: "+sol);
    }

    private static int removeDuplicates(int[] nums) {
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[pointer++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, pointer)));
        return pointer;
    }
}
