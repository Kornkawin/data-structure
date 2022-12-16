package com.dsa.stack.usecase;

import com.dsa.stack.ArrayStack;
import com.dsa.stack.Stack;

public class Brackets {
    public static void main(String[] args) {
        String bracketString = "(2+a[1+{test}])";
        boolean sol = solution(bracketString);
        System.out.println(sol);
    }

    private static boolean solution(String testString) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < testString.length(); i++) {
            char token = testString.charAt(i);
            if (token == '{' || token == '(' || token == '[') {
                stack.push(token);
            } else if (token == '}' && stack.peek() == '{'
                    || token == ')' && stack.peek() == '('
                    || token == ']' && stack.peek() == '[') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
