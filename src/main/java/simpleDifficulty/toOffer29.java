package simpleDifficulty;

public class toOffer29 {
    int way[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int nowX, nowY;
    public int goWay(int[][] matrix, int n){
        nowX += way[n][0];
        nowY += way[n][1];
        if(nowX < matrix.length && nowX >= 0 && nowY < matrix[0].length && nowY >= 0 && matrix[nowX][nowY] != 101)
            return n;
        nowX -= way[n][0];
        nowY -= way[n][1];
        if(n + 1 < way.length)
            n ++;
        else
            n = 0;
        nowX += way[n][0];
        nowY += way[n][1];
        if(nowX < matrix.length && nowX >= 0 && nowY < matrix[0].length && nowY >= 0 && matrix[nowX][nowY] != 101)
            return n;
        nowX -= way[n][0];
        nowY -= way[n][1];
        return way.length;
    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[]{};
        int[] list = new int[matrix.length * matrix[0].length];
        int listIndex = 1;
        list[0] = matrix[0][0];
        matrix[0][0] = 101;
        int n = 0;
        while(true){
            n = goWay(matrix, n);
            if(n == way.length)
                break;
            list[listIndex++] = matrix[nowX][nowY];
            matrix[nowX][nowY] = 101;
        }
        return list;
    }

}
