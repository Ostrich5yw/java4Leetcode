package oldProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class eighteen {
    public static void main(String[] args) {
        eighteen t = new eighteen();
        System.out.println(t.fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int a, b, c;
        int i, j, p;
        int len = nums.length;
        Arrays.sort(nums);
        for(a = 0;a < len - 3;a ++){
            if(a > 0 && nums[a] == nums[a-1])               //如果a与前一个a相同，则直接跳过，防止重复添加相同templist进入list
                continue;
            if(nums[a] + nums[a+1] + nums[a+2] + nums[a+3] > target)         //最关键的剪枝策略，190ms----6ms
                break;
            if(nums[a] + nums[len-3] + nums[len-2] + nums[len - 1] < target) //如果本次循环中，最小的四个之和 > target，则没有其它更小的，直接break；
                continue;                                                    //如果最大的四个之和 < target,则说明此时的a与其它任何3个数都达不到要求，但如果a再向后遍历，依然有可能大于target，所以只是continue；
            for(b = a + 1;b < len - 2;b ++){
                if(b > a + 1 && nums[b] == nums[b-1])
                    continue;
                if(nums[a] + nums[b] + nums[b+1] + nums[b+2] > target)
                    break;
                if(nums[a] + nums[b] + nums[len-2] + nums[len - 1] < target)
                    continue;
                for(c = b + 1;c < len - 1;c ++){
                    if(c > b + 1 && nums[c] == nums[c-1])
                        continue;
                    if(nums[a] + nums[b] + nums[c] + nums[c+1] > target)
                        break;
                    if(nums[a] + nums[b] + nums[c] + nums[len - 1] < target)
                        continue;
                    int temptarget = target - nums[a] - nums[b] - nums[c];
                    i = c + 1;
                    j = len - 1;
//                    System.out.println(a+ " "+ b + " "+  c);
                    while(i <= j) {                                     //a b c确定后，用折半查找确认是否有符合的p满足四数之和 = target
//                        System.out.println(i+ " " + j);
                        p = (i + j) / 2;
                        if(nums[p] == temptarget){list.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c], nums[p]))); break;};
                        if(nums[p] > temptarget) j = p - 1;
                        if(nums[p] < temptarget) i = p + 1;
                    }
                }
            }
        }
        return list;
    }
}

