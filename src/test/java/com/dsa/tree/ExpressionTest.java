package com.dsa.tree;

import java.util.List;

class ExpressionTest {
    public static void main(String[] args) {
        String infix = "( 80 - 30 ) * ( 40 + 50 / 10 )";
        String[] input = infix.split(" ");
        Expression expression = new Expression(input);
        System.out.println(expression);
        System.out.println(expression.eval());
    }
}