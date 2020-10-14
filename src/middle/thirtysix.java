package middle;
import java.util.ArrayList;
import java.util.HashSet;

public class thirtysix {
    public static void main(String[] args) {
        thirtysix t = new thirtysix();
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
        ArrayList<HashSet<Character>> markmatrix = new ArrayList<>();
        for(i = 0;i < 9;i ++)
            markmatrix.add(new HashSet<>());
        ArrayList<HashSet<Character>> markcolumn = new ArrayList<>();
        for(i = 0;i < 9;i ++)
            markcolumn.add(new HashSet<>());
        int matrix_pos = 0, column_pos = 0;
        for(i = 0;i < 9;i ++){
            for(j = 0;j < 9;j ++){
                int marki = i / 3, markj = j / 3;
                if(marki == 0 && markj == 0) matrix_pos = 0;else if(marki == 1 && markj == 0) matrix_pos = 1;else if(marki == 2 && markj == 0) matrix_pos = 2;else if(marki == 0 && markj == 1) matrix_pos = 3;else if(marki == 1 && markj == 1) matrix_pos = 4;else if(marki == 2 && markj == 1) matrix_pos = 5;else if(marki == 0 && markj == 2) matrix_pos = 6;else if(marki == 1 && markj == 2) matrix_pos = 7;else if(marki == 2 && markj == 2) matrix_pos = 8;
                column_pos = j;
                if(board[i][j] != '.') {
                    if(!markrow.add(board[i][j]))
                        return false;
                    if(!markmatrix.get(matrix_pos).add(board[i][j]))
                        return false;
                    if(!markcolumn.get(column_pos).add(board[i][j]))
                        return false;
                }
            }
            markrow.clear();
        }
        return true;
    }
}

