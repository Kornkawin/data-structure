package com.dsa.queue.usecase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class BfsMul3Div2 {
    public static void main(String[] args) {
        int target = 39;
        System.out.println(target + "=");
        bfsMul3Div2(target);
    }

//    private static class Node {
//        private final int value;
//        private final Node prev;
//
//        public Node(int value, Node prev) {
//            this.value = value;
//            this.prev = prev;
//        }
//
//        public boolean equals(Object obj) {
//            if (this == obj) return true;
//            if (!(obj instanceof Node)) return false;
//            if (!super.equals(obj)) return false;
//            Node that = (Node) obj;
//            return this.value == that.value;
//        }
//    }

    private record Node(int value, Node prev) {}

    private static void bfsMul3Div2(int target) {
        // Set for all nodes
        // Queue for not-calculated nodes
        Set<Node> set = new HashSet<>();
        Deque<Node> que = new ArrayDeque<>();

        // initial
        Node v = new Node(1, null);
        que.offer(v); set.add(v);

        // search
        while (!que.isEmpty()) {
            v = que.poll();
            if (v.value == target)
                // found
                break;

            // create new branches if new value
            Node v1 = new Node(v.value/2, v);
            Node v2 = new Node(v.value*3, v);
            if (!set.contains(v1)) {
                que.offer(v1); set.add(v1);
            }
            if (!set.contains(v2)) {
                que.offer(v2); set.add(v2);
            }
        }
        if (v.value == target) showSolution(v);
    }

    private static void showSolution(Node node) {
        if (node.prev == null) {
            // for root node
            System.out.print("1");
        } else {
            // recursive case
            showSolution(node.prev);
            String step = (node.prev.value / 2 == node.value) ? " /2" : " *3";
            System.out.print(step);
        }
    }
}
