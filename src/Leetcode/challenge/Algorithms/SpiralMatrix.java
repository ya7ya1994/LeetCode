class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOutput = new ArrayList<>();
        
        if (matrix.length == 0) {
            return spiralOutput;
        }
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Top
            for (int i = left; i <= right; i++) {
                spiralOutput.add(matrix[top][i]);
            }
            top++;

            // Right
            for (int i = top; i <= bottom; i++) {
                spiralOutput.add(matrix[i][right]);
            }
            right--;

            // Bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiralOutput.add(matrix[bottom][i]);
                }
            }
            bottom--;

            // Left
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralOutput.add(matrix[i][left]);
                }
            }
            left++;
        }

        return spiralOutput;
    }

}
