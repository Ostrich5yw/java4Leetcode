package MediumDifficulty;

public class toOffer12 {
    int[][] way = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean dfs(char[][] board, int nowPos, String target, int x, int y){
        if(nowPos >= target.length())
            return true;
        char targetWord = target.charAt(nowPos);
        for(int i = 0;i < 4;i ++){
            char nowWord = board[x][y];
            board[x][y] = '0';
            x += way[i][0];
            y += way[i][1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && nowWord == targetWord && dfs(board, nowPos + 1, target, x, y))
                return true;
            x -= way[i][0];
            y -= way[i][1];
            board[x][y] = nowWord;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        char mark = word.charAt(0);
        for(int i = 0;i < board.length;i ++)
            for(int j = 0;j < board[0].length;j ++){
                if(mark == board[i][j]){
                    if(dfs(board, 0, word, i, j) || (word.length() == 1))
                        return true;
                }
            }
        return false;
    }
}
