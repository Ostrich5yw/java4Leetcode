package middle;

import java.util.ArrayList;
import java.util.List;

public class p120 {
    public static void main(String[] args) {
        p120 t = new p120();
        List<Integer> list1 = new ArrayList<Integer>(){{add(2);}};
        List<Integer> list2 = new ArrayList<Integer>(){{add(3);add(4);}};
        List<Integer> list3 = new ArrayList<Integer>(){{add(6);add(5);add(7);}};
        List<Integer> list4 = new ArrayList<Integer>(){{add(4);add(1);add(8);add(3);}};
        List<List<Integer>> list = new ArrayList<List<Integer>>(){{add(list1);add(list2);add(list3);add(list4);}};
        System.out.println(t.minimumTotal(list));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int n = triangle.size();
        int [][]matrix = new int[n][n];
        matrix[0][0] = triangle.get(0).get(0);
        for(int i = 1;i < n; i ++){
            int jlen = triangle.get(i).size();
            matrix[i][0] =  matrix[i - 1][0] + triangle.get(i).get(0);          //我们遍历到每一层，第一个元素的最短路径之和只与i-1,j有关
            matrix[i][jlen - 1] =  matrix[i - 1][jlen - 2] + triangle.get(i).get(jlen - 1);
                                            //最后一个元素的最短路径之和只与i-1,j-1有关   所以我们提前计算出这两个特殊位置的值
            /**
             * 其他位置到顶点的最小距离为：matrix[i][j] = min{ matrix[i-1][j-1], matrix[i-1][j]} + c[i][j]
             * c[i][j]为当前点的value值
             * **/
            for(int j = 1;j < jlen - 1; j ++){
                matrix[i][j] = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        for(int p = 0;p < matrix[n - 1].length; p ++){      //找出从底端到顶端最小的位置
            if(matrix[n - 1][p] < minLen)
                minLen = matrix[n - 1][p];
        }
//        for(int i = 0;i < matrix.length;i ++) {
//            for (int j = 0; j < matrix[i].length; j++)
//                System.out.print(matrix[i][j] + " ");
//            System.out.println();
//        }
        return minLen;
    }
}
