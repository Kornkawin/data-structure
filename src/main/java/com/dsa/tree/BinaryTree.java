package com.dsa.tree;

import java.util.Arrays;

public class BinaryTree {
    protected static class Node {
        protected Object element;
        protected Node left, right;
        protected Node(Object e, Node l, Node r) {
            this.element = e;
            this.left = l;
            this.right = r;
        }

        protected boolean isLeaf() {
            return left == null && right == null;
        }
    }

    protected Node root;

    public int numNodes() {
        return numNodes(root);
    }

    public int height() {
        return height(root);
    }

    protected int numNodes(Node node) {
        if (node == null) return 0;
        return 1 + numNodes(node.left) + numNodes(node.right);
    }

    protected int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    protected Node copy(Node r) {
        if (r == null) return null;
        Node leftTree = copy(r.left);
        Node rightTree = copy(r.right);
        return new Node(r, leftTree, rightTree);
    }

    public void preOrder(Visitor v) {
        preOrder(root, v);
    }

    protected void preOrder(Node x, Visitor v) {
        if (x == null || v.isDone()) return;
        v.visit(x.element);
        preOrder(x.left, v);
        preOrder(x.right, v);
    }

    public void inOrder(Visitor v) {
        inOrder(root, v);
    }

    protected void inOrder(Node x, Visitor v) {
        if (x == null || v.isDone()) return;
        inOrder(x.left, v);
        v.visit(x.element);
        inOrder(x.right, v);
    }

    public void postOrder(Visitor v) {
        postOrder(root, v);
    }

    protected void postOrder(Node x, Visitor v) {
        if (x == null || v.isDone()) return;
        postOrder(x.left, v);
        postOrder(x.right, v);
        v.visit(x.element);
    }

    // preOrder
//    public Object[] toArray() {
//        int n = numNodes();
//        Object[] a = new Object[n];
//        toArray(root, a, 0);
//        return a;
//    }
//
//    private int toArray(Node x, Object[] arr, int idx) {
//        if (x == null) return idx;
//        // preOrder
//        arr[idx++] = x.element;
//        idx = toArray(x.left, arr, idx);
//        idx = toArray(x.right, arr, idx);
//        return idx;
//    }

    // toArray() with Visitor pattern (more flexible)
    public Object[] toArray() {
        Object[] arr = new Object[numNodes()];
        Visitor v = new Visitor() {
            int k = 0;
            @Override
            public void visit(Object element) {
                arr[k++] = element;
            }
        };
        preOrder(v);
        return arr;
    }

    public boolean contains(Object x) {
        Visitor v = new Visitor() {
            @Override
            public void visit(Object element) {
                if (element.equals(x)) done();
            }
        };
        preOrder(v);
        return v.isDone();
    }

    @Override
    public String toString() {
        Object[] arr = toArray();
        return Arrays.toString(arr);
    }
}
