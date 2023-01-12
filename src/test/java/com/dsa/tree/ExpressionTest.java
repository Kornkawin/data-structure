package com.dsa.tree;

class ExpressionTreeTest {
    public static void main(String[] args) {
        String infix = "( 80 - 30 ) * ( 40 + 50 / 10 )";
        String[] input = infix.split(" ");
        ExpressionTree expression = new ExpressionTree(input);
        System.out.println(expression);
        System.out.println(expression.eval());
    }
}