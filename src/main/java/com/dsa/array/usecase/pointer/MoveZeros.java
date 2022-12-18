package com.dsa.array.usecase.pointer;

import java.util.Arrays;

public class MoveZeros {

    // Time: O(n)
    // Space: O(1)
    // Fast-slow pointers -> run p1 one loop
    private static void moveZeros(int[] nums) {
        for (int p1 = 0, p2 = 0; p1 < nums.length; p1++) {
            if (nums[p1] != 0) {
                // swap
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        moveZeros(input);
        System.out.println("Ans: "+ Arrays.toString(input));
    }
}
