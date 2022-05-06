package MediumDifficulty;

import java.util.ArrayList;
import java.util.List;


public class p78 {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        p78 t = new p78();
        System.out.println(t.subsets(new int[]{1, 2, 3}));
    }
    /**
     * 位运算
     * 1，2，3得到所有子集，我们只需使用
     * 0，0，1   0，1，0    0，1，1   1，0，0   1，0，1   1，1，0   1，1，1
     * 每次输出位为1的，即可得到它的全部子集
     * **/
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int mark;
        List<Integer> list = new ArrayList<>();
        for(mark = 0;mark < (1 << len);mark ++){        //mark遍历0，1，2，3，4，5，6，7
            list.clear();                           //清空数组
            /**
             * 这里i是关键，i从0到2，再由(1<<i)转化为001，010，100.负责与mark做与运算，mark哪一位为1，则被下面的if判别出来并加入list数组
             * **/
            for(int i = 0;i < len;i ++){
                if((mark & (1 << i)) != 0){         //注意这里如mark = 7，则三次&运算求出来的是：001，010，100即1，2，4，所以判断!=0
                    list.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(list));        //这里需要新建一个数组并用list初始化，直接add(list)加入的是指针
        }
        return res;
    }
    /**
     * 和之前一样的深搜遍历
     * **/
//    public void findSubsets(int[] nums, int now,List<Integer> list){
//        List<Integer> temp = new ArrayList<>();
//        for(int x: list)
//            temp.add(x);
//        res.add(temp);
//        for(int i = now + 1;i < nums.length;i ++){
//            list.add(nums[i]);
//            findSubsets(nums, i, list);
//            list.remove(list.size() - 1);
//        }
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        findSubsets(nums, -1, new ArrayList<Integer>());
//        return res;
//    }
}
