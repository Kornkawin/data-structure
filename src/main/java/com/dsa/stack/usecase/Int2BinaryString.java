package com.dsa.stack.usecase;

import java.util.ArrayDeque;

public class Int2BinaryString {
    public static void main(String[] args) {
        int input = 21;
        String sol = int2BinaryString(input);
        System.out.println(sol);
    }

    // 21 = 2*10 + 1
    // 10 = 2*5 + 0
    //  5 = 2*2 + 1
    //  2 = 2*1 + 0
    //  1 = 2*0 + 1
    // ans: 10101
    //  2 = 2*1 + 0
    //  1 = 2*0 + 1
    // ans: 10
    private static String int2BinaryString(int num) {
        String result = "";
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (num > 0) {
            int rem = num % 2;
            stack.push(rem);
            num /= 2;
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
