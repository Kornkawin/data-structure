package com.dsa.tree;


import com.dsa.priorityqueue.BinaryMinHeap;

public class HuffmanTree extends BinaryTree implements Comparable<Object> {

    public HuffmanTree(Integer freq, Node left, Node right) {
        this.root = new Node(freq, left, right);
    }

    public int freq() {
        return (int) root.element;
    }

    @Override
    public int compareTo(Object obj) {
        return freq() - ((HuffmanTree) obj).freq();
    }

    public static HuffmanTree coding(int[] freq) {
        BinaryMinHeap heap = new BinaryMinHeap(freq.length);
        for (int f: freq)
            heap.offer(new HuffmanTree(f, null, null));
        for(int i = 0; i<freq.length-1; i++) {
            HuffmanTree t1 = (HuffmanTree) heap.poll();
            HuffmanTree t2 = (HuffmanTree) heap.poll();
            int f = t1.freq() + t2.freq();
            heap.offer(new HuffmanTree(f, t1.root, t2.root));
        }
        HuffmanTree tree = (HuffmanTree) heap.poll();
        System.out.println(tree);
        return tree;
    }

    @Override
    public String toString() {
        return "HuffmanTree [root=" + root + "]";
    }
}
