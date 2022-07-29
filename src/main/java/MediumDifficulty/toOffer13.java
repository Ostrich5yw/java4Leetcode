package MediumDifficulty;

public class toOffer13 {
    int[][] mark;
    public boolean isLegel(int x, int y, int k){
        if(x >= mark.length || x < 0 || y >= mark[0].length || y < 0 || mark[x][y] == 1)
            return false;
        return k >= x % 10 + x / 10 + y % 10 + y / 10;
    }
    public int dfs(int x, int y, int k){
        if(!isLegel(x, y, k))
            return 0;
        mark[x][y] = 1;
        return dfs(x + 1, y, k) + dfs(x, y + 1, k) + 1;
    }
    public int movingCount(int m, int n, int k) {
        mark = new int[m][n];
        return dfs(0, 0, k);
    }
}
