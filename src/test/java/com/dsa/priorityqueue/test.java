package com.dsa.priorityqueue;

public class test {
    public static void main(String[] args) {
        PriorityQueue que = new ArrayPQ();
        que.offer(2);
        que.offer(10);
        que.offer(5);
        System.out.println(que.poll());
        System.out.println(que.poll());

        PriorityQueue maxQue = new BinaryHeap(10);
        maxQue.offer(2);
        maxQue.offer(10);
        maxQue.offer(5);
        System.out.println(maxQue.poll());
        System.out.println(maxQue.poll());

        PriorityQueue minQue = new BinaryMinHeap(10);
        minQue.offer(2);
        minQue.offer(10);
        minQue.offer(5);
        System.out.println(minQue.poll());
        System.out.println(minQue.poll());

        PriorityQueue minQue2 = new BinaryMinHeapExtended(10);
        minQue2.offer(2);
        minQue2.offer(10);
        minQue2.offer(5);
        System.out.println(minQue2.poll());
        System.out.println(minQue2.poll());
    }
}
