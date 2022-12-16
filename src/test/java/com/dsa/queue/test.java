package com.dsa.queue;

public class test {
    public static void main(String[] args) {

        IntQueue q = new IntQueue(5);

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);

        System.out.println(q.poll()); // 1
        System.out.println(q.poll()); // 2
        System.out.println(q.poll()); // 3
        System.out.println(q.poll()); // 4

        System.out.println(q.isEmpty()); // false

        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.poll()); // 5
        System.out.println(q.poll()); // 1
        System.out.println(q.poll()); // 2
        System.out.println(q.poll()); // 3

        System.out.println(q.isEmpty()); // true

        benchMarkTest();
    }

    // BenchMark IntQueue vs ArrayDeque.
    private static void benchMarkTest() {

        int n = 10000000;
        IntQueue intQ = new IntQueue(n);

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intQ.offer(i);
        for (int i = 0; i < n; i++) intQ.poll();
        long end = System.nanoTime();
        System.out.println("IntQueue Time: " + (end - start) / 1e9);

        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        // java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n); // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.offer(i);
        for (int i = 0; i < n; i++) arrayDeque.poll();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);
    }
}
