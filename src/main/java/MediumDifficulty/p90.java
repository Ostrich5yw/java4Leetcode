package MediumDifficulty;

import java.util.*;

public class p90 {
    List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        p90 t = new p90();
        System.out.println(t.subsetsWithDup(new int[]{1, 2, 2}));
    }
    public void findSubset(int[] nums, List<Integer> nowList, int nowPos){
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i < nowList.size();i ++) {
            temp.add(nowList.get(i));
        }
        list.add(temp);
        for(int i = nowPos;i < nums.length;i ++){
            if(i > nowPos && nums[i] == nums[i - 1]){           //注意此处的剪枝操作，是判断i > nowPos,
                continue;                                       //比如我们以nowList = 1，2进入本层for循环，从i=2开始遍历，此时nums[i]=2,但是仍可以加入数组
            }                                                   //我们这个判断是为了避免同层for循环中，在i=1和i=2时两次递归nowList=1，2
//            System.out.println(i);
            nowList.add(nums[i]);
            findSubset(nums, nowList, i + 1);
            nowList.remove(nowList.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        findSubset(nums, new ArrayList<>(), 0);
        return list;
    }
}
