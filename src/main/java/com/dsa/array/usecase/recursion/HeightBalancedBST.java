package com.dsa.array.usecase.recursion;

public class HeightBalancedBST {

    public static void main(String[] args) {
        int[] input = {-10,-3,0,5,9};
        TreeNode sol = sortedArrayToBST(input);
        System.out.println(sol.val+","+sol.left.val+","+sol.right.val);
        System.out.println(sol.left.val+","+sol.left.right.val);
        System.out.println(sol.right.val+","+sol.right.right.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if(left > right) return null;

        int pivot = (left + right)/2;
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = helper(nums, left, pivot-1);
        root.right = helper(nums, pivot+1, right);
        return root;
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}
