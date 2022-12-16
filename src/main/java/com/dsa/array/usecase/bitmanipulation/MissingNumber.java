package com.dsa.array.usecase.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    // Time: O(n)
    // Space: O(1)
    // XOR (^):
    //  0 ^ 0 == 0
    //  1 ^ 0 == 1
    //  0 ^ 1 == 1
    //  1 ^ 1 == 0
    //  Ex len=4, arr=[0,1,3,4]
    //  -> missing = 4 ^ (0^0) ^ (1^1) ^ (2^3) ^ (3^4)
    //  ->         = (4^4) ^ (0^0) ^ (1^1) ^ (3^3) ^ 2
    //  ->         = 0 ^ 0 ^ 0 ^ 0 ^ 2
    //  ->         = 2
    private static int missingNumberBitMan(int[] nums) {
        int missing = nums.length;
        for (int i=0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Time: O(n)
    // Space: O(1)
    // Gauss Formula
    private static int missingNumberGauss(int[] nums) {
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        // closed-form n(n+1)/2 = sum(X) where X = 0,1,2,3,..,n
        int expectedSum = nums.length*(nums.length+1)/2;
        return expectedSum - actualSum;
    }

    // Time: O(n)
    // Space: O(n)
    // Intuition Hash
    private static int missingNumberHash(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);
        int expectedMaxNum = nums.length;
        for (int number = 0; number <= expectedMaxNum; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {9,6,4,2,3,5,7,0,1};
        int sol = missingNumberGauss(input);
        System.out.println("Ans: "+sol);
    }
}
