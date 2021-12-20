public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {



        int rows = matrix.length;
        int cols = matrix[0].length;
        int squareLength [][] = new int [rows+1][cols+1];
        int max = 0;


        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                if(matrix[i-1][j-1] == '1') {
                    squareLength[i][j] = Math.min(
                            squareLength[i][j-1],
                            Math.min(squareLength[i-1][j-1],
                                    squareLength[i-1][j])) + 1;
                }

                max = Math.max(max,squareLength[i][j]);
            }
        }


        return max * max;
    }
}
