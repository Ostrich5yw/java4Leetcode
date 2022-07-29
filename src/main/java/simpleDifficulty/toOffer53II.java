package simpleDifficulty;

public class toOffer53II {
    public int missingNumber(int[] nums) {
        if(nums.length == 1)
            return nums.length - nums[0];
        int basic = 0;
        for(int i = 0;i < nums.length;i ++){
            if(nums[i] != basic){
                return basic;
            }
            basic ++;
        }
        return nums.length;
    }
}
