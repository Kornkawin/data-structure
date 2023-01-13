package com.dsa.tree;

class ExpressionTreeTest {
    public static void expressionTreeTest() {
        String infix = "( 80 - 30 ) * ( 40 + 50 / 10 )";
        String[] input = infix.split(" ");
        ExpressionTree expression = new ExpressionTree(input);
        System.out.println(expression);
        System.out.println(expression.eval());

        infix = "( x ^ 2 + 2 ) * x";
        input = infix.split(" ");
        expression = new ExpressionTree(input);
        System.out.println(expression);
        expression.diff();
        System.out.println("diff(): " + expression);

        infix = "x / 2";
        input = infix.split(" ");
        expression = new ExpressionTree(input);
        System.out.println(expression);
        expression.diff();
        System.out.println("diff(): " + expression);
    }
}