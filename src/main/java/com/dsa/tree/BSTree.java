package com.dsa.tree;

public class BSTree extends BinaryTree {
    int size;

    public BSTree() {
        super();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected int compare(Object a, Object b) {
        return ((Comparable) a).compareTo(b);
    }

    // Time: O(h), h is the height of the tree
    // floor(log2(n)) <= height <= n-1
    // Best case & Average case: O(log(n))
    // Worst case: O(n)
    public Object get(Object e) {
        Node node = getNode(root, e);
        return node == null ? null : node.element;
    }

    // Time: O(h)
    // Best case & Average case: O(log(n))
    // Worst case: O(n)
    protected Node getNode(Node node, Object e) {
        if (node == null) return null;
        int cmp = compare(e, node.element);
        if (cmp == 0) return node;
        if (cmp < 0) return getNode(node.left, e);
        return getNode(node.right, e);
    }

    // Time: O(h)
    // Best case & Average case: O(log(n))
    // Worst case: O(n)
    public Object getMin() {
        Node r = root;
        if (r == null) return null;
        while (r.left != null) r = r.left;
        return r.element;
    }

    // Time: O(h)
    // Best case & Average case: O(log(n))
    // Worst case: O(n)
    public Object getMax() {
        Node r = root;
        if (r == null) return null;
        while (r.right != null) r = r.right;
        return r.element;
    }

    // Time: O(h)
    // Best case & Average case: O(log(n))
    // Worst case: O(n)
    public void add(Object e) {
        root = add(root, e);
    }

    // don't add duplicate data
    protected Node add(Node r, Object e) {
        if (r == null) {
            size++;
            return new Node(e);
        }
        int cmp = compare(e, r.element);
        if (cmp < 0) r.left = add(r.left, e);
        else if (cmp > 0) r.right = add(r.right, e);
        return r;
    }

    // Time: O(h)
    // Best case & Average case: O(log(n))
    // Worst case: O(n)
    public void remove(Object e) {
        root = remove(root, e);
    }

    protected Node remove(Node r, Object e) {
        if (r == null) return null;
        int cmp = compare(e, r.element);
        if (cmp < 0) r.left = remove(r.left, e);
        else if (cmp > 0) r.right = remove(r.right, e);
        else {
            // found the node to be removed
            // case: one child or no child
            if (r.left == null) {
                r = r.right;
            } else if (r.right == null) {
                r = r.left;
            } else {
                // case: two children
                // To replace the removed node with
                // the smallest node in the right subtree
                Node min = r.right;
                while (min.left != null) min = min.left;
                r.element = min.element;
                r.right = remove(r.right, min.element);
            }
            size--;
        }
        return r;
    }

    // inOrder traversal of the tree
    // Best & Average case: Time Complexity = O(n log n) = O(n log n) + O(n)
    // Worst case: O(n^2)
    public static void treeSort(Object[] data) {
        BSTree tree = new BSTree();
        // O(n log n) or O(n^2)
        for (Object e: data) tree.add(e);
        // O(n)
        tree.inOrder(new Visitor() {
            int k = 0;
            @Override
            public void visit(Object element) {
                data[k++] = element;
            }
        });
    }
}
