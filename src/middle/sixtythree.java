package middle;


import java.util.Arrays;

public class sixtythree {
    private int[][] mark = new int [101][101];
    public static void main(String[] args) {
        sixtythree t = new sixtythree();
        System.out.println(t.uniquePathsWithObstacles(new int[][]{
                        {0 ,0 ,0},
                        {0, 1, 0},
                        {0, 0, 0}
                }
        ));
    }
    /**
     * 使用滚动数组的动态规划
     * **/
    public int uniquePathsWithObstacles(int[][] map) {
        if(map.length == 0)
            return 0;
        int n = map.length;
        int m = map[0].length;
        int[] dp = new int[m];
        dp[0] = map[0][0] == 1 ? 0 : 1;             //将0列的元素初始化，如果不可达则置为0，否则为1(即只有一种路径从0，0到0，0)
        for(int i = 0;i < n;i ++)               //动态规划遍历数组
            for(int j = 0;j < m;j ++){
                if(map[i][j] == 1)              //如果该点为障碍点，即走不到该位置，则置为0
                {
                    dp[j] = 0;
                    continue;
                }
                if(j - 1 >= 0)                  //需要注意的是，dp[0]在全程始终为1，除非进入第一个if，有可能被置为0
                {
                    /**
                     * 当前，dp[j]记录的是i-1，j的值，而dp[j-1]记录的是i,j-1的值
                     * 所以二者之和计入dp[j]，作为i，j的值
                     * **/
                    dp[j] = dp[j] + dp[j - 1];         //到达i,j点的路径数，等于到达i-1,j与i,j-1的路径数之和
                }
            }
        return dp[m - 1];
    }
    /**
     * 普通动态规划
     * **/
//    public int uniquePathsWithObstacles(int[][] map) {
//        if(map.length == 0)
//            return 0;
//        int n = map.length;
//        int m = map[0].length;
//        int[][] dp = new int[n][m];
////        dp[0][0] = dp[0][0] == 1 ? 0 : 1;
//        Arrays.fill(dp[0], 1);              //将第一行与第一列的所有值变为1，因为到达第一行或第一列的元素，都只有1种路径
//        for(int i = 0;i < n;i ++) dp[i][0] = 1;
//        for(int i = 0;i < n;i ++)               //动态规划遍历数组
//            for(int j = 0;j < m;j ++){
//                if(map[i][j] == 1)              //如果该点为障碍点，即走不到该位置，则置为0
//                {
//                    dp[i][j] = 0;
//                    continue;
//                }
//                if(j - 1 >= 0 && i - 1 >= 0)
//                {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];         //到达i,j点的路径数，等于到达i-1,j与i,j-1的路径数之和
//                }else{
//                    if(j - 1 >= 0)                                    //这里主要是考虑map只有一行或一列的情况
//                        dp[i][j] = dp[i][j - 1];
//                    if(i - 1 >= 0)
//                        dp[i][j] = dp[i - 1][j];
//                }
//            }
//        return dp[n - 1][m - 1];
//    }
    /**
     * 递归
     * **/
//    public int findWay(int[][] map, int col,int arr, int x, int y){
//        int sum1 = 0, sum2 = 0;
//        if(mark[col][arr] != 0)
//            return mark[col][arr];
////        System.out.println(col + " " + arr);
//        if(col == x && arr == y) {
//            return 1;
//        }
//        if(col + 1 <= x && map[col + 1][arr] != 1)      //在62题的基础上加入节点是否存在障碍物的判断
//            sum1 = findWay(map,col + 1, arr, x, y);
//        if(arr + 1 <= y && map[col][arr + 1] != 1)
//            sum2 = findWay(map, col, arr + 1, x, y);
//        mark[col][arr] = sum1 + sum2;
//        return sum1 + sum2;
//    }
//    public int uniquePathsWithObstacles(int[][] map) {
//        if(map.length == 0)
//            return 0;
//        int n = map.length;
//        int m = map[0].length;
//        if(map[0][0] == 1 || map[n - 1][m - 1] == 1)        //终点或起点有障碍物，直接返回0
//            return 0;
//        return findWay(map,0 , 0, n - 1, m - 1);
//    }
}
