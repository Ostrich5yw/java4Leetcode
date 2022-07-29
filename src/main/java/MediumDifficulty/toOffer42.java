package MediumDifficulty;

public class toOffer42 {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int maxSum = nums[0];
        for(int i = 0;i < nums.length;i ++){
            if(sum < 0){
                sum = nums[i];
                maxSum = Math.max(maxSum, sum);
                continue;
            }
            maxSum = Math.max(maxSum, sum);
            sum += nums[i];
        }
        return Math.max(maxSum, sum);
    }
}
