package com.dsa.tree;

import java.util.Arrays;

class BSTreeTest {
    public static void bsTreeTest() {
        Integer[] input = { 50, 30, 70, 20, 40, 60, 80 };
        System.out.println(Arrays.toString(input));
        BSTree.treeSort(input);
        System.out.println(Arrays.toString(input));
    }
}