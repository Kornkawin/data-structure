package com.dsa.array.usecase.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleRow {
    // formula: pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
    // Time: O(k^2)
    // Space: O(k)
    private static List<Integer> pascalTriangleRow(int rowIndex) {
        int n_rows = rowIndex + 1;
        List<Integer> row = new ArrayList<>(n_rows);
        row.add(1); // rowNum = 0
        for (int rowNum = 1; rowNum < n_rows; rowNum++) {
            for (int index = rowNum-1; index > 0; index--) {
                row.set(index, row.get(index) + row.get(index - 1));
            }
            row.add(1);
        }
        return row;
    }

    public static void main(String[] args) {
        int index = 0;
        List<Integer> sol = pascalTriangleRow(index);
        System.out.println(sol);
    }
}
