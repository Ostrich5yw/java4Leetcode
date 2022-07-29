package MediumDifficulty;

import java.util.Arrays;

public class p64 {
    public static void main(String[] args) {
        p64 t = new p64();
        System.out.println(t.minPathSum(new int[][]{
                {1, 3, 2},
                {1, 5, 1},
                {4, 2, 1}  }
        ));
    }
    /**
     * 使用滚动数组的动态规划
     * **/
    public int minPathSum(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);     //这句和下面的一句主要是为了解决第一行的问题，
        dp[0] = 0;
        for(int i = 0;i < n;i ++)
            for(int j = 0;j < m;j ++){
                if(j - 1 >= 0)
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                    //考虑到第一行的特殊性，所以将dp初始化为MAX，这样第一行遍历才会正确给dp数组赋值。
                    //dp[j]指向i-1,j  dp[j-1]指向i,j-1  二者比较小的加上该点的值，就是到达i，j的最短路径和
                else
                    dp[j] = dp[j] + grid[i][j];         //需要将dp[0]初始化为0，这里才会正确将0，0赋值为1
//                System.out.println(j + " " + dp[j]);
            }
        return dp[m - 1];
    }
    /**
     * 普通动态规划
     * **/
//    public int minPathSum(int[][] grid) {
//        if(grid.length == 0)
//            return 0;
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] dp = new int[n][m];
//        dp[0][0] = grid[0][0];
//        for(int i = 1;i < n;i ++) dp[i][0] = dp[i - 1][0] + grid[i][0];
//        for(int j = 1;j < m;j ++) dp[0][j] =  dp[0][j - 1] + grid[0][j];
//        for(int i = 1;i < n;i ++)
//            for(int j = 1;j < m;j ++){
//                dp[i][j] = Math.min(dp[i -1][j], dp[i][j - 1]) + grid[i][j];
//            }
//        return dp[n - 1][m - 1];
//    }
}

