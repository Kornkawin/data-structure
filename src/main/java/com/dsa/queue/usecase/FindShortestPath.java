package com.dsa.queue.usecase;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FindShortestPath {
    private static final Pos source = new Pos(0,0);
    private static final Pos target = new Pos(0,4);

    public static void main(String[] args) {
        int[][] board = new int[5][5];
        findShortPath(board);
    }

    private record Pos(int row, int col) { }

    private static void findShortPath(int[][] map) {
        map[source.row][source.col] = 0;    // start
        map[target.row][target.col] = -1;   // end

        // initial
        showPath(map);
        Queue<Pos> que = new ArrayDeque<>(map.length);
        que.offer(source);
        // search
        while (!que.isEmpty()) {
            Pos p = que.poll();
            expand(map, que, p.row+1, p.col, map[p.row][p.col] + 1);
            expand(map, que, p.row-1, p.col, map[p.row][p.col] + 1);
            expand(map, que, p.row, p.col+1, map[p.row][p.col] + 1);
            expand(map, que, p.row, p.col-1, map[p.row][p.col] + 1);
        }
    }

//    private static void expand(int[][] map,
//                               Queue<Pos> que,
//                               int nextRow,
//                               int nextCol,
//                               int nextStep) {
//        Pos nextPos = new Pos(nextRow, nextCol);
//        if (nextPos.equals(target)) {
//            System.out.println(nextPos);
//            System.out.println("Found at step"+nextStep);
//            showPath(map);
//            System.exit(0);
//        } else if (nextRow<0 || nextCol<0
//                || nextRow>=map.length || nextCol>=map[nextRow].length
//                || map[nextRow][nextCol] != 0 || nextPos.equals(source)) {
//            return;
//        }
//        System.out.println(nextPos);
//        map[nextRow][nextCol] = nextStep;
//        que.offer(nextPos);
//        showPath(map);
//    }

    private static void expand(int[][] map,
                               Queue<Pos> que,
                               int nextRow,
                               int nextCol,
                               int nextStep) {
        Pos nextPos = new Pos(nextRow, nextCol);
        if (nextRow<0 || nextCol<0
                || nextRow>=map.length || nextCol>=map[nextRow].length
                || map[nextRow][nextCol] != 0 || nextPos.equals(source)) {
            return;
        }
        System.out.println(nextPos);
        map[nextRow][nextCol] = nextStep;
        que.offer(nextPos);
        showPath(map);
    }

    private static void showPath(int[][] map) {
        for (int[] row : map)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }
}
