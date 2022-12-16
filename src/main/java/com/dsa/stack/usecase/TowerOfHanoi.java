package com.dsa.stack.usecase;

import java.util.Stack;

public class TowerOfHanoi {
    private static final int N = 3;
    private static final Stack<Integer>[] towers = new Stack[3];

    public static void main(String args[]) {
        // A, B and C are names of rods
        // N is the number of disk
        towerOfHanoiRecursive(N, 'A', 'C', 'B');
        System.out.println();
        towerOfHanoiStackRecursive(N);
    }

    // Time: O(2^n), There are two possibilities for every disk
    // Space: O(N), Function call stack space (Recursive)
    private static void towerOfHanoiRecursive(int n,
                                              char from_rod,
                                              char to_rod,
                                              char aux_rod) {
        // base
        if (n == 0) {
            return;
        }
        // recursive
        towerOfHanoiRecursive(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod "
                + from_rod + " to rod "
                + to_rod);
        towerOfHanoiRecursive(n - 1, aux_rod, to_rod, from_rod);
    }

    private static void towerOfHanoiStackRecursive(int n) {
        towers[0] = new Stack<>();
        towers[1] = new Stack<>();
        towers[2] = new Stack<>();
        for (int d = n; d > 0; d--)
            towers[0].push(d);
        display();
        move(n, 0, 2, 1);
    }

    // recursive method
    public static void move(int n, int from, int to, int aux)
    {
        if (n > 0)
        {
            move(n-1, from, aux, to);
            int d = towers[from].pop();
            towers[to].push(d);
            display();
            move(n-1, aux, to, from);
        }
    }

    private static void display() {
        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");
        for(int i = N - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(towers[0].get(i));
            }
            catch (Exception e) {}
            try {
                d2 = String.valueOf(towers[1].get(i));
            }
            catch(Exception e) {}
            try {
                d3 = String.valueOf(towers[2].get(i));
            }
            catch (Exception e) {}
            System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
        }
        System.out.println("\n");
    }
}
