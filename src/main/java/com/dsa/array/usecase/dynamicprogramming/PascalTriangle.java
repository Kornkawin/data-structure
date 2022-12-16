package com.dsa.array.usecase.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    // Time: O(n_rows^2)
    private static List<List<Integer>> pascalTriangle(int n_rows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        int rowNum = 1;
        while (rowNum < n_rows) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1);
            for (int i = 1; i < prevRow.size(); i++) {
                // prevRow.size() == rowNum
                int sum = prevRow.get(i) + prevRow.get(i-1);
                row.add(sum);
            }
            row.add(1);
            triangle.add(row);

            ++rowNum;
        }
        return triangle;
    }

    public static void main(String[] args) {
        int input = 5;
        List<List<Integer>> sol = pascalTriangle(input);
        System.out.println(sol);
    }
}
