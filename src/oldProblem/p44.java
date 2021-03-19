package oldProblem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *  本题中，不再采用调整数组位置的方式记录已经加入exist中的数字，而引入一个记录数组rec，当加入exist中时，为true，否则为false
 *
 *
 * **/
public class p44 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] rec;
    public static void main(String[] args) {
        p44 t = new p44();
        System.out.println(t.permuteUnique(new int[]{0, 1, 0 ,0, 9}));
    }

    public int findSequence(int[] nums, List<Integer> exist){
        if(exist.size() == nums.length){                 //如果当前数组长度等于nums长度，说明exist已经加入了nums中所有数字，则将其加入res数组
            List<Integer> list = new ArrayList<>();
            for(int n:exist)
                list.add(n);
            res.add(list);
            return 1;
        }
        for(int i = 0;i < nums.length;i ++){        //遍历还未加入exist的数字
            /**
             * 广度搜索（回溯）
             * **/
            if(rec[i] || (i > 0 && nums[i] == nums[i - 1] && !rec[i-1]))    //如果其上一位与当前i一致，则跳过本次循环
                continue;
            exist.add(nums[i]);                         //新数加入exist并将它的rec记录为true(表示已经加入exist)
            rec[i] = true;
            findSequence(nums, exist);   //加入新数后，向下一层继续递归
            rec[i] = false;                             //回退
            exist.remove(exist.size() - 1);
        }
        return 0;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> exist =new ArrayList<>();
        rec = new boolean[nums.length];
        Arrays.sort(nums);
        findSequence(nums, exist);
        return res;
    }
}

