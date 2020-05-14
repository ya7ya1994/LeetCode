package Leetcode.challenge.Algorithms;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return paths(m, n, 0, 0, new HashMap<>()).intValue();
    }

    private Integer paths(int m, int n, int col, int row, Map<String, Integer> result) {
        if (row == m - 1 || col == n - 1) return 1;
        if (result.containsKey(row + "," + col)) return result.get(row + "," + col);
        result.put(row + "," + col, paths(m, n, col + 1, row, result) + paths(m, n, col, row + 1, result));
        return result.get(row + "," + col);
    }
}
