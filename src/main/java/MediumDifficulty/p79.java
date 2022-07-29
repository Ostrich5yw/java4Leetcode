package MediumDifficulty;

/**
 * 深度搜索
 * **/

public class p79 {
    int[][] way = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}            //右，左，下，上
    };
    public static void main(String[] args) {
        p79 t = new p79();
        System.out.println(t.exist(new char[][]{
                {'A','A','A'},
                {'A','A','A'},
                {'A','A','A'}
        }, "AAAAAAAAA"));
    }
    /**
     * mark记录已走到过的位置，now记录当前匹配到word第几位，x，y记录当前在矩阵中的位置
     * **/
    public boolean Dfs(char[][] board, int[][] mark, String word, int now, int x, int y){
        if(now == word.length()) {      //now长度等于word长度时，说明已经将字符串遍历完毕
            return true;
        }
        for(int i = 0;i < 4;i ++){
            int tempx = x + way[i][0];
            int tempy = y + way[i][1];
//            System.out.println(tempx+ " " + tempy + " " + now);
            if(tempx >= 0 && tempy >=0 && tempx < board.length && tempy < board[0].length    //判断tempx，tempy是否在合理位置
                    && mark[tempx][tempy] == 0 && board[tempx][tempy] == word.charAt(now)) { //如果位置尚未访问过并且与字符串下一位匹配
                mark[tempx][tempy] = 1;
                if (Dfs(board, mark, word, now + 1, tempx, tempy))  //如果为true则直接返回
                    return true;
                mark[tempx][tempy] = 0;
            }
        }
        return false;       //上下左右遍历后，都没有匹配完字符串，则返回false
    }
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        if(word.length() == 0) return false;
        int[][] mark = new int[board.length][board[0].length];
        for(int i = 0; i < board.length;i ++)
            for(int j = 0; j < board[0].length;j ++) {          //我们可以从任意起点开始，匹配word
                mark[i][j] = 1;
                if (board[i][j] == word.charAt(0) && Dfs(board, mark, word, 1, i, j) == true)
                    return true;
                mark[i][j] = 0;
            }
        return false;
    }
}
