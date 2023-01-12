package com.dsa.tree;

public class BinaryTree {
    protected static class Node {
        protected Object element;
        protected Node left, right;
        protected Node(Object e, Node l, Node r) {
            this.element = e;
            this.left = l;
            this.right = r;
        }

        @Override
        public String toString() {
            return element.toString();
        }

        protected boolean isLeaf() {
            return left == null && right == null;
        }
    }

    protected Node root;
}
