package middle;

public class p130 {
    int [][]pos = new int[][]{ {0, 1}, {0, -1}, {-1, 0}, {1, 0} }; //上，下，左， 右
    public static void main(String[] args) {
        p130 t = new p130();
        t.solve(new char[][]{
                {}});
    }
    public boolean outEdge(int x, int y, int width, int height){        //判断当前位置是否超出边界
        if(x < 0 || x > width - 1 || y < 0 || y > height - 1)
            return true;
        return false;
    }
    public void recursionBoard(int x, int y, char[][] board){           //进行递归，寻找和外部O相连的所有O，并将其置为Y
        for(int i = 0;i < 4; i ++){
            int nowx = x + pos[i][0];       //pos数组存放上下左右四个方向
            int nowy = y + pos[i][1];
//            System.out.println(nowx + " " + nowy);
            if(!outEdge(nowx, nowy, board.length, board[0].length) && board[nowx][nowy] == 'O'){
                board[nowx][nowy] = 'Y';
                recursionBoard(nowx, nowy, board);
            }
        }
    }
    public void solve(char[][] board) {
        int width = board[0].length;
        int height = board.length;
        /**
         * 首先我们遍历最外圈，对于外部是O的，我们寻找与它相连的O，并将这些O置为Y
         * **/
        for(int i = 0;i < width;i ++)
            if(board[0][i] == 'O') {board[0][i] = 'Y'; recursionBoard(0, i, board);}
        for(int i = 1;i < height;i ++)
            if(board[i][width - 1] == 'O') {board[i][width - 1] = 'Y';recursionBoard(i, width - 1, board);};
        for(int i = width - 2;i >= 0;i --)
            if(board[height - 1][i] == 'O') {board[height - 1][i] = 'Y';recursionBoard(height - 1, i, board);};
        for(int i = height - 2;i > 0;i --)
            if(board[i][0] == 'O') {board[i][0] = 'Y';recursionBoard(i, 0, board);};
        /**
         *
         * 遍历完成后，和外部相连的O目前都变成了Y，剩下被包围的O仍旧是O
         * 所以我们再对矩阵进行依次遍历，将所有Y(未被包围的)替换为O，将O(被包围的)替换为X
         *
         * **/
        for(int i = 0;i < board.length;i ++)
        {
            for(int j = 0; j < board[0].length;j ++)
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'Y')
                    board[i][j] = 'O';
        }
        for(int i = 0;i < board.length;i ++) {
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }
}
