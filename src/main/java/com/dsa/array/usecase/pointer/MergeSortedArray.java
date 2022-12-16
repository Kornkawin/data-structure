package com.dsa.array.usecase.pointer;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] input1 = {1,2,3,0,0,0};
        int len1 = 3;
        int[] input2 = {2,5,6};
        int len2 = 3;

        int[] sol = mergeSortedArray(input1, len1, input2, len2);
        System.out.println("Ans: "+ Arrays.toString(sol));
    }

    // Time: O(n+m), n=sizeOfArr1,m=sizeOfArr2
    // 3 pointers
    private static int[] mergeSortedArray(int[] nums1, int len1, int[] nums2, int len2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;

        while (pointer1 < len1 && pointer2 < len2) {
            if (nums1[pointer1] <= nums2[pointer2]) {
                ++pointer1; ++pointer3;
            } else {
                int tmp = nums1[pointer3];
                nums1[pointer3++] = nums2[pointer2];
                nums1[pointer3] = tmp;
                ++pointer2;
            }
        }
        while (pointer2 < len2) {
            nums1[pointer3++] = nums2[pointer2++];
        }
        return nums1;
    }
}
