class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] pascalTriangle = new int[rowIndex+1][rowIndex+1];
        pascalTriangle[0][0] = 1;
        for (int i = 1; i < rowIndex+1; i++){
            pascalTriangle[i][0] = 1;
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
            }
            pascalTriangle[i][i] = 1;
        }
        
        List<Integer> row = new ArrayList<>();
        for (int cell : pascalTriangle[rowIndex]) {
            row.add(cell);
        }
        
        return row;
        
    }
}
