package com.dsa.array.usecase.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Time: O(n)
    // Space: O(n)
    // Hashing (Intuition)
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i : nums) {
            hashTable.put(i, hashTable.getOrDefault(i, 0) + 1);
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : hashTable.entrySet()) {
            if (majorityEntry == null
                    || majorityEntry.getValue() < entry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    // Time: O(NLogN)
    // Space: O(1)
    // Sorting lib
    private static int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Time: O(n)
    // Space: O(1)
    // If an element majority_element occurs more than n/2 times,
    // then there are at least n/2 elements of identical values
    // with num at each bit.
    // That is, we can reconstruct the exact value of num
    // by combining the most frequent value (0 or 1) at each bit.
    private static int majorityElementBitMan(int[] nums) {
        int sol = 0;
        for (int i = 0; i < 31; i++) {
            int bit = 1 << i;

            int bitCount = 0;
            for (int num : nums) {
                if ((bit & num) != 0) bitCount++;
            }

            if (bitCount > nums.length/2) {
                sol |= bit;
            }
        }
        return sol;
    }

    // Time: O(n)
    // Space: O(1)
    // Boyer-Moore Voting Algorithm (Easy)
    private static int majorityElementBoyerMooreVoting(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) count++;
            else count--;
        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int sol = majorityElementBoyerMooreVoting(nums);
        System.out.println("Ans: "+sol);
    }
}
