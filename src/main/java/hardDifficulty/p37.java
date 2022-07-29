package hardDifficulty;

/**
 * @author 5yw
 * @date 2022/4/12 11:26
 */
public class p37 {
    public boolean Dfs(int i, int j, char[][] board, boolean[][] row, boolean[][] column, boolean[][] tube){    //后三个参数分别用来判断，当前位置(i,j)填入一数字后是否合法
        int p = i / 3 * 3 + j / 3;
        for(int a1 = 0;a1 < 9 ;a1 ++){      //遍历1-9，即该位置可以填入的所有数字
            if(!row[i][a1] && !column[j][a1] && !tube[p][a1]){//判断该位置填入相应数字后，是否负责数独规则
                row[i][a1] = true;
                column[j][a1] = true;
                tube[i / 3 * 3 + j / 3][a1] = true;
                board[i][j] = (char)(a1 + 1 + '0');
                int tj = j + 1;
                if (i == 8 && j == 8)
                    return true;
                for(int ti = i;ti < 9;ti ++) {      //当前位置填入a1+1后，继续寻找并迭代下一个'.'位置
                    for (; tj < 9; tj++) {
                        if (board[ti][tj] == '.') {
                            if (Dfs(ti, tj, board, row, column, tube))
                                return true;
                            ti = 10;
                            break;
                        }
                        if (ti == 8 && tj == 8) //两处if (ti == 8 && tj == 8)分别用来做递归停止条件，即分别为board[8][8]是'.'和数字的情况
                            return true;
                    }
                    tj = 0;     //因为遍历是从(i,j）开始找下一个，所以此处tj=0是配合循环实现矩阵遍历
                }
                row[i][a1] = false;     //填入a1无法满足后续位置满足条件，则向前回溯
                column[j][a1] = false;
                tube[i / 3 * 3 + j / 3][a1] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];    // 9个长度为9的判别串。分别用来判断(i,j)上可以存放的数字，row[i][a1]=true 表示第i行已经存在a1
        boolean[][] column = new boolean[9][9];     //column[j][a1]=true 表示第j列已经存在a1
        boolean[][] tube = new boolean[9][9];//tube[i / 3 * 3 + j / 3][a1]=true 表示第i / 3 * 3 + j / 3个正方形内已经存在a1
        for(int i = 0;i < board.length;i ++)
            for(int j = 0;j < board[0].length;j ++){       //由于已经拥有一些数字，所以进行初始化
                if(board[i][j] != '.'){
                    int a1 = board[i][j] - '0' - 1;
                    row[i][a1] = true;
                    column[j][a1] = true;
                    tube[i / 3 * 3 + j / 3][a1] = true;
                }
            }
        for(int i = 0;i < board.length;i ++)         //寻找迭代起始位置，即第一个'.'
            for(int j = 0;j < board[0].length;j ++)
                if(board[i][j] == '.')
                    Dfs(i, j, board, row, column, tube);
    }
}
