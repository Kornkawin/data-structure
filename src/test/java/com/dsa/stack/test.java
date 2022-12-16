package com.dsa.stack;

public class test {
    public static void main(String[] args) {

        IntStack s = new IntStack(5);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.pop()); // 5
        System.out.println(s.pop()); // 4
        System.out.println(s.pop()); // 3

        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) System.out.println(s.pop());

        benchMarkTest();
    }

    private static void benchMarkTest() {

        int n = 10000000;
        IntStack intStack = new IntStack(n);
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intStack.push(i);
        for (int i = 0; i < n; i++) intStack.pop();
        long end = System.nanoTime();
        System.out.println("IntStack Time: " + (end - start) / 1e9);

//        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
//        java.util.Stack<Integer> arrayDeque = new java.util.Stack<>();
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>(n);
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.push(i);
        for (int i = 0; i < n; i++) arrayDeque.pop();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);

        Stack<Integer> listStack = new ListStack<>();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) listStack.push(i);
        for (int i = 0; i < n; i++) listStack.pop();
        end = System.nanoTime();
        System.out.println("ListStack Time: " + (end - start) / 1e9);

        Stack<Integer> arrayStack = new ArrayStack<>();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayStack.push(i);
        for (int i = 0; i < n; i++) arrayStack.pop();
        end = System.nanoTime();
        System.out.println("ArrayStack Time: " + (end - start) / 1e9);
    }
}
