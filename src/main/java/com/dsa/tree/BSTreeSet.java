package com.dsa.tree;

import com.dsa.Set;

public class BSTreeSet implements Set {
    // composition pattern
    protected BSTree tree = new BSTree();

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void remove(Object element) {
        tree.remove(element);
    }

    @Override
    public boolean contains(Object element) {
        return tree.get(element) != null;
    }

    @Override
    public void add(Object element) {
        // BSTree don't add duplicate data
        tree.add(element);
    }
}
