package hard;

import java.util.ArrayList;
import java.util.List;

public class p164 {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        int n = nums.length;
        int max = nums[0];
        //找出最大的数字
        for (int i = 1; i < n; i++) {
            max = Math.max(nums[i], max);
        }
        int exp = 1;
        //一位一位的进行
        while (max > 0) {
            //将之前的元素清空
            for (int i = 0; i < 10; i++) {
                lists.set(i, new ArrayList<>());
            }
            //将数字放入对应的位置
            for (int i = 0; i < n; i++) {
                lists.get(nums[i] / exp % 10).add(nums[i]);
            }

            //将数字依次拿出来
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    nums[index ++] = lists.get(i).get(j);
                }
            }
            max /= 10;
            exp *= 10;
        }

        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > maxGap) {
                maxGap = nums[i + 1] - nums[i];
            }
        }
        return maxGap;
    }
//    public int[] MSDSort(int[] nums, int digit){
//        if(digit == -1)
//            return nums;
//        int point = 0;
//        int[][] bucket = new int[10][nums.length];
//        for(int i = 1;i <= nums[0];i ++){
//            int nowPos = (int)((nums[i] / (int)Math.pow(10, digit)) % 10);
//            bucket[nowPos][++ bucket[nowPos][0]] = nums[i];
//        }
//
//        for(int i = 0;i < 10;i ++){
//            if(bucket[i][0] > 1){
//                bucket[i] = MSDSort(bucket[i], digit - 1);
//            }
//            for (int j = 1;j <= bucket[i][0];j ++)
//                nums[++ point] = bucket[i][j];
//        }
//        return nums;
//    }
//    public int maximumGap(int[] nums) {
//        if (nums.length == 1)
//            return 0;
//        int maxPos = 0;
//        int maxGap = 0;
//        int[] newNums = new int[nums.length + 1];
//        newNums[0] = nums.length;
//        for(int i = 0;i < nums.length;i ++) {
//            int temp = String.valueOf(nums[i]).length();
//            maxPos = Math.max(maxPos, temp);
//            newNums[i + 1] = nums[i];
//        }
//        nums = MSDSort(newNums, maxPos);
//        printArray1D(nums);
//        for(int i = 2;i < nums.length;i ++){
//            maxGap = Math.max(maxGap, Math.abs(nums[i] - nums[i - 1]));
//        }
//        return maxGap;
//    }
}
