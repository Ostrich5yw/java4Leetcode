package middle;

/**
 *同样可以使用动态规划，因为我们知道，一点到终点的路径数，一定等于它向右走一步到终点的距离，加上它向下走一步到终点的距离
 * 即可以列出dp数组
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]   其中dp表示到达i，j点最大的路径数
 * 并且dp[0][j]与dp[i][0]均为1，
 *
 * 即有for (int i = 0; i < n; i++) dp[0][i] = 1;
 *         for (int i = 0; i < m; i++) dp[i][0] = 1;
 *         for (int i = 1; i < m; i++) {
 *             for (int j = 1; j < n; j++) {
 *                 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 *             }
 *         }
 * **/

public class p62 {
    /*****************************************************************************************/
    private int[][] mark = new int [101][101];
    public static void main(String[] args) {
        p62 t = new p62();
        System.out.println(t.uniquePaths(19,  13));
    }
    public int findWay(int col,int arr, int x, int y){
        int sum1 = 0, sum2 = 0;
        /*****************************************************************************************/
        if(mark[col][arr] != 0)         //如果已经计算过这个点到终点的路径数了，就不再重复计算了
            return mark[col][arr];
//        System.out.println(col + " " + arr);
        if(col == x && arr == y) {              //走到最终位置，返回1
            return 1;
        }
        if(col + 1 <= x)
            sum1 = findWay(col + 1, arr, x, y);     //尝试向下走
        if(arr + 1 <= y)
            sum2 = findWay(col, arr + 1, x, y);     //尝试向右走
        /**
         * 三行加绿色标注的部分，记录了矩阵中某些已经遍历过的位置到达终点的路径数，避免了重复计算
         *                          7*3
         *                     6*3       7*2
         *                  5*3   6*2 6*2   7*1
         *
         * 显然，递归中多次计算了6*2这个位置到达终点的路径数，所以我们这里使用mark记录结点的路径数，防止重复计算
         * **/
        mark[col][arr] = sum1 + sum2;       //mark记录这个节点到终点的路径数
        return sum1 + sum2;             //它向下和向右到达终点的路径数和，就是这个节点到终点的路径数
    }
    public int uniquePaths(int m, int n) {
        return findWay(0 , 0, n - 1, m - 1);
    }
}
