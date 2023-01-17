package com.dsa.tree;

public class AVLTree extends BSTree {
    private static class AVLNode extends Node {
        private int height;

        public AVLNode(Object data) {
            super(data);
        }

        public AVLNode(Object data, Node left, Node right) {
            super(data, left, right);
            setHeight();
        }

        void setHeight() {
            height = 1 + Math.max(height(left), height(right));
        }

        int height(Node node) {
            return node == null ? -1 : ((AVLNode) node).height;
        }

        int balanceFactor() {
            // 0: balanced (AVL)
            // +1: right heavy (AVL)
            // -1: left heavy (AVL)
            // +2: right very heavy (NO)
            // -2: left very heavy (NO)
            return height(right) - height(left);
        }
    }

    @Override
    protected Node add(Node r, Object e) {
        if(r == null) {
            r = new AVLNode(e); size++;
        } else {
            // add, then rebalanced
            r = super.add(r, e);
            r = rebalance(r);
        }
        return r;
    }

    @Override
    protected Node remove(Node r, Object e) {
        r = super.remove(r, e);
        r = rebalance(r);
        return r;
    }

    // Time: O(1)
    protected Node rebalance(Node r) {
        if(r == null) return null;
        int bf = ((AVLNode) r).balanceFactor();
        if(bf == 2) {
            // right very heavy
            if(((AVLNode) r.right).balanceFactor() == -1) {
                // right-left heavy
                r = rotateRightLeftChild(r);
            } else {
                // right-right heavy
                r = rotateRightChild(r);
            }
        } else if(bf == -2) {
            // left very heavy
            if(((AVLNode) r.left).balanceFactor() == 1) {
                // left-right heavy
                r = rotateLeftRightChild(r);
            } else {
                // left right heavy
                r = rotateLeftChild(r);
            }
        }
        return r;
    }

    @Override
    protected Node rotateLeftChild(Node r) {
        r = super.rotateLeftChild(r);
        // set new height for rotated subtree
        ((AVLNode) r.right).setHeight();
        ((AVLNode) r).setHeight();
        return r;
    }

    @Override
    protected Node rotateRightChild(Node r) {
        r = super.rotateRightChild(r);
        // set new height for rotated subtree
        ((AVLNode) r.left).setHeight();
        ((AVLNode) r).setHeight();
        return r;
    }
}
