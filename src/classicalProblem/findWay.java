package classicalProblem;

public class findWay {
        int way[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int minNum = Integer.MAX_VALUE;
        public int findRoad(char[][] grid,int nowNum, int x, int y){
            if(x == grid.length - 1 && y == grid[0].length - 1) {
                minNum = nowNum < minNum ? nowNum : minNum;
                return 0;
            }
            for(int i = 0;i < 4; i++){
                int tempx = x + way[i][0];
                int tempy = y + way[i][1];
                if((0 > tempx || tempx >= grid[0].length || 0 > tempy || tempy >= grid.length) || grid[tempx][tempy] == '0')
                    continue;
                char temp = grid[tempx][tempy];
                grid[tempx][tempy] = '0';
                if(temp == '#')
                    nowNum ++;
                findRoad(grid, nowNum, tempx, tempy);
                if(temp == '#')
                    nowNum --;
                grid[tempx][tempy] = temp;
            }
            return minNum;
        }
        public static void main(String[] args){
            char [][]map = new char[][]{{'.', '.', '#'},
                    {'#', '#', '#'},
                    {'#', '.', '.'}};
            new findWay().findRoad(map, 0, 0, 0);
        }
}
