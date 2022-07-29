package simpleDifficulty;

public class toOffer4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int n = matrix.length, m = matrix[0].length;
        int row = 0, column = m - 1;
        while (row < n && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}
