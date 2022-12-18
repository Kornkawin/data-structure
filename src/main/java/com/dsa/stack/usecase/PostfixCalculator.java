package com.dsa.stack.usecase;

import java.util.ArrayDeque;

// Prefix: +AB
// Infix: A+B
// Postfix: AB+
public class PostfixCalculator {
    public static void main(String[] args) {
        String postfix = "80 30 - 40 50 10 / + *";
        String[] input = postfix.split(" ");
        double sol = postfixCalculation(input);
        System.out.println("Ans: "+sol);
    }

    private static double postfixCalculation(String[] input) {
        ArrayDeque<Double> stack = new ArrayDeque<>();
        for (String token : input) {
            double temp = 0;
            if (token.equals("+")) {
                temp = stack.pop() + stack.pop();
                stack.push(temp);
            } else if (token.equals("-")) {
                double y = stack.pop();
                double x = stack.pop();
                temp =  x - y;
                stack.push(temp);
            } else if (token.equals("*")) {
                temp = stack.pop() * stack.pop();
                stack.push(temp);
            } else if (token.equals("/")) {
                double y = stack.pop();
                double x = stack.pop();
                temp = x / y;
                stack.push(temp);
            } else stack.push(Double.parseDouble(token));
        }
        return stack.pop();
    }
}
