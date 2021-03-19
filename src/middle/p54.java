package middle;
import java.util.ArrayList;
import java.util.List;

public class p54 {
    public static void main(String[] args) {
        p54 t = new p54();
        System.out.println(t.spiralOrder(new int[][]{
                {1, 2, 3 , 5},
                {4, 5, 6 , 5},
                {7, 8, 9 , 5},
                {1, 1, 1 , 1}
        }));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)                              //矩阵无元素则直接跳出
            return res;
        int mark = matrix.length == matrix[0].length ? 1:0;         //mark = 1时为正方形矩阵， mark = 0时为矩形矩阵
        int nowcol = 0, nowarr = 0;
        int scol = 0, ecol = matrix.length - 1, sarr = 0, earr = matrix[0].length - 1;  //分别记录行的上下边界，列的左右边界
        /**
         *
         * 1为正方形矩阵时，行列边界是一致的。
         * 0为矩形矩阵时，行与列只要有一个已经超出边界就要跳出。
         * 每一圈都顺时针扫描矩阵，分为4次循环，即上，右，下，左，每完成一个方向扫描，都要将指针(nowcol,nowarr)对到下一个方向的第一个元素
         * 并将边界值向内部靠拢(上边界，左边界增加，下边界，右边界减小)
         *
         * **/
        while ((mark == 1 && (scol <= ecol || sarr <= earr)) || (mark == 0 && (scol <= ecol && sarr <= earr))){     //指示循环到第几圈
            if(nowcol >= scol && nowcol <= ecol && nowarr >= sarr && nowarr <= earr) {      //上   且指针在边界范围内
                while (nowarr <= earr) {
//                    System.out.println(nowcol + " " + nowarr);
                    res.add(matrix[nowcol][nowarr++]);
                }
                nowarr--;       //指针指向下一个遍历的第一个元素(右上角下方的元素)
                nowcol++;
            }
            scol += 1;          //边界缩小
            if(nowcol >= scol && nowcol <= ecol && nowarr >= sarr && nowarr <= earr) {      //右     且指针在边界范围内
                while (nowcol <= ecol) {
                    res.add(matrix[nowcol++][nowarr]);
                }
                nowarr--;       //指针指向下一个遍历的第一个元素(右下角左方的元素)
                nowcol--;
            }
            earr -= 1;      //边界缩小
            if(nowcol >= scol && nowcol <= ecol && nowarr >= sarr && nowarr <= earr) {      //下     且指针在边界范围内
                while (nowarr >= sarr) {
                    res.add(matrix[nowcol][nowarr--]);
                }
                nowcol--;       //指针指向下一个遍历的第一个元素(左下角上方的元素)
                nowarr++;
            }
            ecol -= 1;      //边界缩小
            if(nowcol >= scol && nowcol <= ecol && nowarr >= sarr && nowarr <= earr) {      //左     且指针在边界范围内
                System.out.println(nowcol + " " + nowarr);

                while (nowcol >= scol) {
                    res.add(matrix[nowcol--][nowarr]);
                }
                nowarr++;       //指针指向下一个遍历的第一个元素(左上角右下方的元素---就是内圈的第一个元素)
                nowcol++;
            }
            sarr += 1;      //边界缩小
//            scol += 1; sarr += 1;
//            ecol -= 1; earr -= 1;
//            System.out.println(sarr+" "+earr+" "+scol+" "+ecol);
        }
        return res;
    }
}

