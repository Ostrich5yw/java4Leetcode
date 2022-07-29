package simpleDifficulty;

import java.util.ArrayList;
import java.util.List;

public class p1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] temp = new int[n];
        while(--k >= 0){
            for(int i = 0;i < n;i ++){
                temp[i] = grid[i][m - 1];
            }
            for(int j = m - 1;j >= 1;j --){
                for(int i = 0;i < n;i ++){
                    grid[i][j] = grid[i][j - 1];
                }
            }
            for(int i = n - 1;i > 0;i --){
                grid[i][0] = temp[i - 1];
            }
            grid[0][0] = temp[n - 1];
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i < n;i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j < m;j ++){
                list.add(grid[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}
