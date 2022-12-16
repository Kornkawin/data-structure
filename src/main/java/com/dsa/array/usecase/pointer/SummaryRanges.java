package com.dsa.array.usecase.pointer;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    private static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int currIndex = 0;
        int p = 0;
        int len = nums.length;
        while(currIndex < len) {
            p = currIndex;

            // append
            while (p+1 < len && nums[p+1] == nums[p]+1) ++p;

            if (currIndex == p) {
                ans.add(String.valueOf(nums[p]));
            } else {
                ans.add(nums[currIndex]+"->"+nums[p]);
            }
            currIndex = p+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {0,2,3,4,6,8,9};
        List<String> ans = summaryRanges(input);
        System.out.println(ans);
    }
}
