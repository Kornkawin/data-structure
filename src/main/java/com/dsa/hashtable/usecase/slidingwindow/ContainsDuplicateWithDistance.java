package com.dsa.hashtable.usecase.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateWithDistance {
    private static boolean containsDuplicateWithDistance(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (window.contains(nums[i])) return true;
            else {
                window.add(nums[i]);
                if (window.size() > k) window.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1,2,2,1,5};
        int k = 3;
        boolean sol = containsDuplicateWithDistance(input, k);
        System.out.println("Ans: "+sol);
    }
}
