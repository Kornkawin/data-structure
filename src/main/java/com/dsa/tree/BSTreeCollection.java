package com.dsa.tree;

import com.dsa.Collection;

/**
 *  Feature: can add duplicate data for collection interface
 *  Rule
 *  1. New duplicate data will go to left subtree when added
 *  2. Duplicate data can go to right subtree when removing other nodes (permitted)
 */
public class BSTreeCollection extends BSTree implements Collection {
    @Override
    protected Node add(Node r, Object e) {
        if (r == null) {
            r = new Node(e);
            size++;
        } else {
            int cmp = compare(e, r.element);
            // add duplicate data to left subtree
            if (cmp <= 0) r.left = add(r.left, e);
            else r.right = add(r.right, e);
        }
        return r;
    }
}
