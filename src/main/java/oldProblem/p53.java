package oldProblem;

public class p53 {
    public static void main(String[] args){
        p53 t = new p53();
        System.out.println(t.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public int maxSubArray(int[] nums) {
        int recStart = 0;int recMax = Integer.MIN_VALUE;
        for(int x:nums){                                     //假如有一个数组0，-1，4，5，6，-7
            recStart = Math.max(x, recStart + x);            //这句话用来过滤4之前的负数部分
            recMax = Math.max(recMax, recStart);             //这句话用来过滤4之后的负数部分
        }
        return recMax;
    }

//    public int maxSubArray(int[] nums) {
//        int []maxNums = new int[nums.length];
//        System.arraycopy(nums, 0, maxNums, 0, nums.length);
//        int maxRes = Integer.MIN_VALUE;
//        for(int i = 1; i < nums.length; i ++)
//            maxNums[i] = Math.max(maxNums[i - 1] + nums[i],  nums[i]);
//        for(int x : maxNums)
//            maxRes = x < maxRes ? maxRes : x;
//        return maxRes;
//    }
}
