package com.dsa.tree;

import java.util.*;

public class ExpressionTree extends BinaryTree {
    private static final String OPERATORS = "+-*/^()";
    private static final int[] outsidePriority = {3,3,5,5,8,9,1};
    private static final int[] insidePriority = {3,3,5,5,7,0};

    public ExpressionTree(String[] infix) {
        List<String> postfix = infix2postfix(infix);
        Deque<Node> s = new ArrayDeque<>();
        for (String token : postfix) {
            if (OPERATORS.contains(token)) {
                Node right = s.pop();
                Node left = s.pop();
                Node node = new Node(token, left, right);
                s.push(node);
            } else {
                s.push(new Node(token));
            }
        }
        root = s.pop();
    }

    // copy constructor
    public ExpressionTree(ExpressionTree e) {
        root = copy(e.root);
    }

    public double eval() {
        return eval(root);
    }

    // post order traversal
    private double eval(Node r) {
        if (r == null) return 0;
        if (r.isLeaf()) return Double.parseDouble(r.element.toString());
        double vLeft = eval(r.left);
        double vRight = eval(r.right);
        if (r.element.equals("+")) return vLeft + vRight;
        else if (r.element.equals("-")) return vLeft - vRight;
        else if (r.element.equals("*")) return vLeft * vRight;
        else if (r.element.equals("/")) return vLeft / vRight;
        else if (r.element.equals("^")) return Math.pow(vLeft, vRight);
        else throw new IllegalStateException();
    }

    public void diff() {
        root = diff(root);
    }

    private Node diff(Node r) {
        if (r == null) return null;
        String s = (String) r.element;
        if (r.isLeaf()) {
            r.element = (s.equals("x")) ? "1" : "0";
        } else {
            if(s.equals("+") || s.equals("-")) r = diffSumMinus(r);
            else if(s.equals("*")) r = diffProduct(r);
            else if(s.equals("/")) r = diffDiv(r);
            else if(s.equals("^")) r = diffPower(r);
            else throw new IllegalStateException();
        }
        return r;
    }

    private Node diffSumMinus(Node r) {
        r.left = diff(r.left);
        r.right = diff(r.right);
        return r;
    }

    private Node diffProduct(Node r) {
        Node u = copy(r.left);
        Node v = copy(r.right);
        Node du = diff(r.left);
        Node dv = diff(r.right);
        Node t1 = new Node("*", u, dv);
        Node t2 = new Node("*", v, du);
        return new Node("+", t1, t2);
    }

    private Node diffPower(Node r) {
        // support only x^C where C is a constant
        Node u = copy(r.left);
        Node c = copy(r.right);
        Node c1 = new Node("-", copy(r.right), new Node("1"));
        Node du = diff(r.left);
        Node leftTree = new Node("*", c, new Node("^", u, c1));
        return new Node("*", leftTree, du);
    }

    private Node diffDiv(Node r) {
        // u(x)/v(x)
        Node u = copy(r.left);
        Node v = copy(r.right);
        Node v2 = copy(r.right);
        Node du = diff(r.left);
        Node dv = diff(r.right);
        Node t1 = new Node("*", v, du);
        Node t2 = new Node("*", u, dv);
        Node t3 = new Node("-", t1, t2);
        Node t4 = new Node("^", v2, new Node("2"));
        return new Node("/", t3, t4);
    }

    // ref: stack use case
    public List<String> infix2postfix(String[] infix) {
        List<String> postfix = new ArrayList<>();
        Deque<String> s = new ArrayDeque<>();
        for (String token : infix) {
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

    private int getInsideStackPriority(String token) {
        return insidePriority[OPERATORS.indexOf(token)];
    }

    private int getOutsideStackPriority(String token) {
        return outsidePriority[OPERATORS.indexOf(token)];
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[numNodes()];
        Visitor v = new Visitor() {
            int k = 0;
            @Override
            public void visit(Object element) {
                arr[k++] = element;
            }
        };
        postOrder(v);
        return arr;
    }

    @Override
    public String toString() {
        Object[] arr = toArray();
        return Arrays.toString(arr);
    }
}
