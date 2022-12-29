package com.dsa.stack.usecase;

import com.dsa.stack.ArrayStack;
import com.dsa.stack.Stack;

import java.util.ArrayList;
import java.util.List;

// Prefix: +AB
// Infix: A+B
// Postfix: AB+
public class Infix2Postfix {
    public static void main(String[] args) {
//        String infix = "( 80 - 30 ) * ( 40 + 50 / 10 )";
        String infix = "2 + 3 - 4 ^ 5 ^ 6";
        String[] input = infix.split(" ");
        List<String> postfix = infix2Postfix(input);
        System.out.println(postfix);
    }

    private static final String OPERATORS = "+-*/^()";
    private static final int[] outsidePriority = {3,3,5,5,8,9,1};
    private static final int[] insidePriority = {3,3,5,5,7,0};


    private static List<String> infix2Postfix(String[] input) {
        List<String> postfix = new ArrayList<>();
        Stack<String> s = new ArrayStack<>();
        for(String token : input) {
            if (OPERATORS.contains(token)) {
                int p = getOutsideStackPriority(token);
                while (!s.isEmpty() && getInsideStackPriority(s.peek()) >= p) {
                    postfix.add(s.pop());
                }
                if (")".equals(token)) s.pop(); // pop "("
                else s.push(token);
            } else postfix.add(token);
        }
        while (!s.isEmpty()) postfix.add(s.pop());
        return postfix;
    }

    private static int getInsideStackPriority(String token) {
        return insidePriority[OPERATORS.indexOf(token)];
    }

    private static int getOutsideStackPriority(String token) {
        return outsidePriority[OPERATORS.indexOf(token)];
    }
}
