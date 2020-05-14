package Leetcode.challenge.Algorithms;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return  paths(obstacleGrid,0,0,new HashMap<>()).intValue();
    }

    private Integer paths(int[][] obstacleGrid, int col, int row, Map<String,Integer> result) {
        if ( row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col] == 1) return 0 ;

        if ((row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1)) return 1;

        if (result.containsKey(row+","+col)) return result.get(row+","+col);

        result.put(row+","+col,paths(obstacleGrid,col+1,row,result)+paths(obstacleGrid,col,row+1,result));

        return result.get(row+","+col);
    }
}
