package com.dsa.hashtable.usecase.containing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1,1,2,3,5};
        boolean sol = containsDuplicate(input);
        System.out.println("Ans: "+sol);
    }
}
