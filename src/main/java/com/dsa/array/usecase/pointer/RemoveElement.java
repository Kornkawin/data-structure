package com.dsa.array.usecase.pointer;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        // int[] input = {3,2,2,3};
        int target = 2;
        int sol = removeElement(input, target);
        System.out.println("Ans: "+sol);
    }

    private static int removeElement(int[] nums, int target) {
        int pointer = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != target) {
                nums[pointer++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, pointer)));
        return pointer;
    }
}
