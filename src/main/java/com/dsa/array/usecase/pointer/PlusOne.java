package com.dsa.array.usecase.pointer;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] input = {9,9};
        // int[] input = {1,1,2};
        int[] sol = plusOne(input);
        System.out.println("Ans: "+ Arrays.toString(sol));
    }

    private static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            if (digits[index] != 9) {
                digits[index] += 1;
                return digits;
            } else digits[index--] = 0;
        }
        // All nine
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
