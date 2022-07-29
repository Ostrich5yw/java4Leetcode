package oldProblem;

public class p152 {
    public int maxProduct(int[] nums) {
        int maxRes = Integer.MIN_VALUE;
        int []maxNums = new int[nums.length];           //存放每一个位置可以得到的最大值
        int []minNums = new int[nums.length];           //存放每一个位置可以得到的最小值
        System.arraycopy(nums, 0, maxNums, 0, nums.length);
        System.arraycopy(nums, 0, minNums, 0, nums.length);
        /**
         *    nums      2, 4, -7, 9 , -1
         *    maxNums   2, 8, -7, 9 , -1
         *    minNums   2, 4, -56, -504 , 504
         * **/
        for(int i = 1; i < nums.length; i ++){
            maxNums[i] = Math.max(maxNums[i - 1] * nums[i], Math.max(minNums[i - 1] * nums[i], nums[i]));
            minNums[i] = Math.min(maxNums[i - 1] * nums[i], Math.min(minNums[i - 1] * nums[i], nums[i]));
        }
        for(int x : maxNums)
            maxRes = x < maxRes ? maxRes : x;
        return maxRes;
    }
}
