package Leetcode.challenge.Algorithms;

public class CountServersThatCommunicate {

    int sumRow(int[][] grid, int row) {
        int result = 0;
        for (int cell : grid[row]) {
            result += cell;
        }
        return result;
    }

    int sumCol(int[][] grid, int col) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            result += grid[i][col];
        }
        return result;
    }

    public int countServers(int[][] grid) {
        int connected = 0;
        int[] rowSums = new int[grid.length];
        int[] colSums = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (rowSums[i] == 0) {
                        rowSums[i] = sumRow(grid, i);
                    }
                    if (rowSums[i] > 1) {
                        connected += 1;
                        continue;
                    }

                    if (colSums[j] == 0) {
                        colSums[j] = sumCol(grid, j);
                    }
                    if (colSums[j] > 1) {
                        connected += 1;
                    }

                }
            }
        }

        return connected;
    }
}


