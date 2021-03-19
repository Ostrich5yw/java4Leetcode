package middle;

public class p73 {
    private int[] mark = new int[100];
    public static void main(String[] args) {
        p73 t = new p73();
        t.setZeroes(new int[][]{
                        {0, 1, 2, 0},
                        {3, 4, 5, 2},
                        {1, 3, 1, 5}
                }
        );
    }
    public void setZeroes(int[][] matrix) {
        if(matrix.length != 0) {
            int col = matrix.length;
            int arr = matrix[0].length;
//            int[] markcol = new int[col];           //两个数组分别记录将要置为0的行号与列号
//            int[] markarr = new int[arr];
//            for(int i = 0;i < col;i ++)
//                for(int j = 0;j < arr;j ++){
//                    if(matrix[i][j] == 0){
//                        markcol[i] = 1;             //需要置0的就记录为1
//                        markarr[j] = 1;
//                    }
//                }
//            for(int i = 0;i < col;i ++)             //遍历行，列，将标记为1的行列置0
//                if(markcol[i] == 1)
//                    for(int j = 0;j < arr;j ++)
//                        matrix[i][j] = 0;
//            for(int j = 0;j < arr;j ++)
//                if(markarr[j] == 1)
//                    for(int i = 0;i < col;i ++)
//                        matrix[i][j] = 0;
            /**
             *
             * 我们现在不使用markcol和markarr记录待置0的行列，而在发现0时，直接将对应行，列的非0元素置为-100000，这样既不影响其它0的判断
             * 也可以使用常数量的额外空间(即使用原数组)标记待置0的位置
             *
             * **/
            for(int i = 0;i < col;i ++)
                for(int j = 0;j < arr;j ++){
                    if(matrix[i][j] == 0){
                        for(int p = 0;p < col;p ++)
                            if(matrix[p][j] != 0)
                                matrix[p][j] = -100000;
                        for(int p = 0;p < arr;p ++)
                            if(matrix[i][p] != 0)
                                matrix[i][p] = -100000;
                    }
                }
            for(int i = 0;i < col;i ++)             //对标记为-10000的元素置0
                for(int j = 0;j < arr;j ++)
                    if(matrix[i][j] == -100000)
                        matrix[i][j] = 0;

            for(int i = 0;i < col;i ++) {
                for (int j = 0; j < arr; j++)
                    System.out.print(matrix[i][j]);
                System.out.println();
            }
        }
    }
}
