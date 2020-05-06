package Leetcode.challenge.Algorithms;

import java.util.HashMap;
import java.util.Map;

public class SumPath {

    private static final int INVALID = -1;

    int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        final Map<String, Integer> memo = new HashMap<>();
        return minPathSumHelper(0, 0, grid, memo);
    }

    private int minPathSumHelper(int row, int col, int[][] grid, final Map<String, Integer> memo) {
        final int current = grid[row][col];

        // Check if bottom right element
        if ((row == grid.length - 1) && (col == grid[0].length - 1)) {
            return current;
        }

        final String key = key(row, col);

        // Check if (row, col) already visited
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Compute min path to the bottom (row + 1) and to the right (col + 1)
        int down = (row + 1 < grid.length) ? minPathSumHelper(row + 1, col, grid, memo) : INVALID;
        int right = (col + 1 < grid[0].length) ? minPathSumHelper(row, col + 1, grid, memo)
                : INVALID;

        int minPath;
        if (down == INVALID) { // Current element is on the last row
            minPath = current + right;
        } else if (right == INVALID) { // Current element is on the last column, but not last row
            minPath = current + down;
        } else { // Current element is not on last row/column
            minPath = current + Math.min(right, down);
        }

        // Save min path at current element
        memo.put(key, minPath);

        // Return min path at current element
        return minPath;
    }

    private String key(final int row, final int col) {
        return row + "," + col;
    }


}
