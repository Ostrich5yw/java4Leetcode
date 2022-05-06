package MediumDifficulty;

import java.util.Arrays;
import java.util.Comparator;

public class p56 {
    public static void main(String[] args) {
        p56 t = new p56();
        System.out.println(t.merge(new int[][]{
                {1,4},{2,3}
        }));
    }
//    public void sortInterval(int[][] intervals){                //为输入数组排序，以第一列的元素大小为基准由小到大排序
//        for(int i = 0;i < intervals.length;i ++){
//            for(int j = 1;j < intervals.length;j ++){
//                if(intervals[j][0] < intervals[j - 1][0]){
//                    int temp0 = intervals[j][0], temp1 = intervals[j][1];
//                    intervals[j][0] =  intervals[j - 1][0];
//                    intervals[j][1] =  intervals[j - 1][1];
//                    intervals[j - 1][0] =  temp0;
//                    intervals[j - 1][1] =  temp1;
//                }
//            }
//        }
//    }
    public int[][] merge(int[][] intervals) {
        int[] mark = new int[intervals.length];                         //mark记录这个数组中 j 对应元素是否与其它元素合并，0代表未合并，1代表合并
        int i = 0, j = 1;
        int temp = intervals.length;                                    //temp记录返回数组长度
        Arrays.sort(intervals, new Comparator<int[]> (){        //自带的排序要比我写的快很多
                                    @Override
                                    public int compare(int a[], int b[]){
                                        return a[0] - b[0];
                                    }
            }
        );
        while(i < intervals.length - 1 && j < intervals.length){        //i,j遍历数组。i为基准元素，与j比较得出是否i，j可以合并
            if(mark[i] == 0) {          //如果i还未合并过
                if(intervals[i][0] == intervals[j][0] && i != j) {          //若（1，3）（1，5）则合并得到（1，5）
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    mark[j] = 1;    //j已经被i合并
                    temp --;        //合并了两个元素，总数量减1
                    j++;
                }else if(intervals[i][1] >= intervals[j][0] && i != j){     //若 （1，3）（2，4）或（1，4）（2，3）
                    intervals[i][1] = Math.max(intervals[j][1],intervals[i][1]);
                    mark[j] = 1;
                    temp --;
                    j++;
                }else {         //如果i，j之间没有交集，则说明j之前的所有元素都没有交集，则从j为基准开始继续向后比较
                    i = j;
                    j ++;
                }
            }
        }
        int[][] res = new int[temp][2];
        int tt = 0;
        for(int x = 0; x < mark.length; x ++) {
            if(mark[x] == 0) {
                res[tt][0] = (intervals[x][0]);
                res[tt][1] = (intervals[x][1]);
                tt ++;
            }
        }
        for(int x = 0;x < temp;x ++)
            System.out.println(res[x][0] +" " +res[x][1]);
        return res;
    }
}

