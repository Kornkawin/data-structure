package com.dsa.hashtable.usecase.caching;

public class RangeSumQueryImmutable {
    private static class NumArray {
        private static int[] arr;
        private static int[] sumCached;

        // Time: O(n)
        public NumArray(int[] nums) {
            arr = nums;
            sumCached = new int[arr.length];
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                sumCached[i] = sum;
            }
        }

        // Time: O(1)
        // Space: O(n) - Caching cost
        public int sumRange(int left, int right) {
            return sumCached[right] - sumCached[left] + arr[left];
        }
    }

    public static void main(String[] args) {
        int[] input = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(input);
        System.out.println(array.sumRange(0,2));
    }
}
