package com.dsa.stack.usecase;

import java.util.ArrayDeque;

// Prefix: +AB
// Infix: A+B
// Postfix: AB+
public class Infix2Postfix {
    public static void main(String[] args) {
        String infix = "( 80 - 30 ) * ( 40 + 50 / 10 )";
        String[] input = infix.split(" ");
        String postfix = infix2Postfix(input);
        System.out.println(postfix);
    }

    private static String infix2Postfix(String[] input) {
        String ans = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String token : input) {
            if ("+-*/".contains(token)) stack.push(token);
            else if (token.equals(")")) ans += stack.pop()+" ";
            else if (token.equals("(")) continue;
            else ans += token+" ";
        }
        while (!stack.isEmpty()) {
            ans += stack.pop()+" ";
        }
        return ans;
    }
}
