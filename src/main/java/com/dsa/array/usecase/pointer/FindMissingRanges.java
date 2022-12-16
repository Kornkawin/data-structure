package com.dsa.array.usecase.pointer;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        List<String> sol = findMissingRanges(nums, lower, upper);
        System.out.println(sol);
    }

    private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> sol = new ArrayList<>();
        String elem;
        for (int i = 0; i <= nums.length; i++) {
            elem = null;
            if (nums.length == 0) {
                // edge case
                elem = formatRange(lower, upper);
                if (elem != null) sol.add(elem);
            } else if (i == 0) {
                // edge case
                elem = formatRange(lower, nums[0]-1);
                if (elem != null) sol.add(elem);
            } else if (i == nums.length) {
                // edge case
                elem = formatRange(nums[i-1]+1, upper);
                if (elem != null) sol.add(elem);
            } else {
                // genreral case
                elem = formatRange(nums[i-1]+1, nums[i]-1);
                if (elem != null) sol.add(elem);
            }
        }
        return sol;
    }

    private static String formatRange(int lower, int upper) {
        if (lower == upper)
            return String.valueOf(lower);
        else if (lower < upper)
            return lower+"->"+upper;
        else
            return null;
    }
}
