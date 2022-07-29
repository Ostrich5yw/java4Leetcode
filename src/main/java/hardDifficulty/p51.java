package hardDifficulty;

import java.util.ArrayList;
import java.util.List;

public class p51 {
    List<List<String>>  list;
    public boolean isLegal(char map[][], int x, int y){
        for(int i = 0;i < map.length;i ++){
            if(map[i][y] != '.')
                return false;
        }
        for(int i = 1;i < map.length;i ++){
            if(x+i < map.length && y+i <map.length && map[x + i][y + i] != '.')
                return false;
            if(x-i >= 0 && y-i >= 0 && map[x - i][y - i] != '.')
                return false;
            if(x+i < map.length && y-i >= 0 && map[x + i][y - i] != '.')
                return false;
            if(x-i >= 0 && y+i < map.length && map[x - i][y + i] != '.')
                return false;
        }
        return true;
    }
    public int dfs(char[][] map, int x){
        if(!(x < map.length)){
            List<String> single = new ArrayList<>();
            for(int i = 0;i < map.length;i ++)
                single.add(String.valueOf(map[i]));
            list.add(single);
            return 0;
        }
        for(int y = 0;y < map.length;y ++){
            if(isLegal(map, x, y)) {
                map[x][y] = 'Q';
                dfs(map, x + 1);
                map[x][y] = '.';
            }
        }
        return 0;
    }
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        char[][] map = new char[n][n];
        for(int i = 0;i < n;i ++)
            for(int j = 0;j < n;j ++)
                map[i][j] = '.';
        dfs(map, 0);
        return list;
    }
}
