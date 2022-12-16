package com.dsa.array.usecase.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int sol = singleNumberBitMan(nums);
        System.out.println("Ans: "+sol);
    }

    // Time: O(n)
    // Time: O(n)
    // Hashing
    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : nums)
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        for (int i : hash.keySet())
            if (hash.get(i) == 1) return i;
        return 0;
    }

    // Time: O(n)
    // Space: O(1)
    // Bit Manipulation
    // XOR:
    // 1 ^= 1 == 0
    // (1 ^= 2 ^= 1) == 2 == (1 ^= 1 ^= 2)
    private static int singleNumberBitMan(int[] nums) {
        int sol = 0;
        for (int i : nums) {
            sol ^= i;
        }
        return sol;
    }
}
