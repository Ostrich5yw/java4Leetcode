package oldProblem;

/**
 *
 * 核心是将矩阵当前循环到的最外层看做是4个矩形
 * 123
 * 456
 * 789          将最外层23，14，78，96 看做四块
 * 首先交换2，4；1，3的位置 依次再交换2，8；3，7的位置，最后交换2，6；3，9的位置，就完成了对矩阵的旋转
 * **/
public class p48 {
    public static void main(String[] args) {
        p48 t = new p48();
//        System.out.println(t.rotate(new int[][]{{1, 2, 3},
//                                                {4, 5, 6},
//                                                {7, 8, 9}}
//        ));
        t.rotate(new int[][]{{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15,14,12,16}}
        );
    }
    public void changeNum(int[][] matrix, int x1, int y1, int x2, int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
    public void rotate(int[][] matrix) {
        int len = matrix.length;            //len记录当前循环的最外层矩阵的长度，start记录当前循环的最外层矩阵的起始行/列，end记录终止行/列
        int start = 0;
        int end = len - 1;
        while(len > 1){                     //矩阵长为奇数时，最后循环到1(即循环最小为3*3)，长为偶数时，最后循环到0(即循环最小为2*2)
            System.out.println(start+" " + end + " " + len);
            int tempx,tempy;
            int i;int j;

            //对矩阵做三次上述绿色部分的操作
            i = start;
            for(j = start + 1;j <= end;j ++) {
                //************************
                tempx = len - (j-start) - 1 + start;        //tempx,tempy记录这个的元素将要交换到的位置
                tempy = start;
                System.out.println(i + " " + j + " " + tempx + " " + tempy);
                changeNum(matrix, i, j, tempx, tempy);
            }
            j = start;
            for(i = start;i <= end - 1;i ++){
                tempx = end;
                tempy = i;
                System.out.println(i + " " + j + " " + tempx + " " + tempy);
                changeNum(matrix, i, j, tempx, tempy);
            }
            i = end;
            for(j = start;j <= end - 1;j ++){
                //*************************  这两处位置的tempx要注意，+start是因为j是从start开始，而不是0
                tempx = i - j + start;
                tempy = end;
                System.out.println(i + " " + j + " " + tempx + " " + tempy);
                changeNum(matrix, i, j, tempx, tempy);

            }
            start ++; end --;       //每次循环过后，下一个内圈矩阵长度-2，起始位置和终止位置各+1和-1
            len -= 2;
        }
        for(int i = 0;i < matrix.length;i ++) {         //打印结果
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j]+ " ");
            System.out.println();
        }
    }
}

