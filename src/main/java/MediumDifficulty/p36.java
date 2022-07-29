package MediumDifficulty;
import java.util.ArrayList;
import java.util.HashSet;
/**
 *
 * 只进行一次矩阵遍历（行优先），为行建立一个set数组，为列和矩阵分别建立9个set数组
 *
 *
 * **/
public class p36 {
    /**
     public boolean isValidSudoku(char[][] board) {
     boolean[][] row = new boolean[9][9];    // 9个长度为9的判别串。每一个代表0,1,2,3,4,5,6,7,8 用来去重
     boolean[][] column = new boolean[9][9];
     boolean[][] tube = new boolean[9][9];
     for(int i = 0;i < board.length;i ++)
     for(int j = 0;j < board[0].length;j ++){
     if(board[i][j] != '.'){
     int a1 = board[i][j] - '0' - 1;
     if(row[i][a1] || column[j][a1] || tube[i / 3 * 3 + j / 3][a1])
     return false;
     else{
     row[i][a1] = true;
     column[j][a1] = true;
     tube[i / 3 * 3 + j / 3][a1] = true;
     }
     }
     }
     return true;
     }

     * */
    public static void main(String[] args) {
        p36 t = new p36();
        System.out.println(t.isValidSudoku(new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }
        ));
        System.out.println(t.isValidSudoku(new char[][]
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.' , '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.' , '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6' , '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.' , '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.' , '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.' , '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8' , '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.' , '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7' , '9'}
                }
        ));
    }
    public boolean isValidSudoku(char[][] board) {
        int i, j;
        HashSet<Character> markrow = new HashSet<>();
        ArrayList<HashSet<Character>> markmatrix = new ArrayList<>();   //矩阵数组
        for(i = 0;i < 9;i ++)
            markmatrix.add(new HashSet<>());
        ArrayList<HashSet<Character>> markcolumn = new ArrayList<>();   //列数组
        for(i = 0;i < 9;i ++)
            markcolumn.add(new HashSet<>());
        int matrix_pos = 0, column_pos = 0;
        for(i = 0;i < 9;i ++){
            for(j = 0;j < 9;j ++){
                /**
                 * 通过i,j与3的商，判断当前位置位于哪一个矩阵中
                 * **/
                int marki = i / 3, markj = j / 3;
                if(marki == 0 && markj == 0) matrix_pos = 0;else if(marki == 1 && markj == 0) matrix_pos = 1;else if(marki == 2 && markj == 0) matrix_pos = 2;else if(marki == 0 && markj == 1) matrix_pos = 3;else if(marki == 1 && markj == 1) matrix_pos = 4;else if(marki == 2 && markj == 1) matrix_pos = 5;else if(marki == 0 && markj == 2) matrix_pos = 6;else if(marki == 1 && markj == 2) matrix_pos = 7;else if(marki == 2 && markj == 2) matrix_pos = 8;
                /**
                 * 记录当前位置应该位于哪一个列
                 * **/
                column_pos = j;
                if(board[i][j] != '.') {        //只记录非空值
                    /**
                     *  如果插入失败，说明当前值不是该行，列，矩阵中的唯一值，直接返回false
                     * **/
                    if(!markrow.add(board[i][j]))
                        return false;
                    if(!markmatrix.get(matrix_pos).add(board[i][j]))
                        return false;
                    if(!markcolumn.get(column_pos).add(board[i][j]))
                        return false;
                }
            }
            markrow.clear();    //由于行数组只有一个，所以每次遍历完一行要将其清空
        }
        return true;
    }
}

