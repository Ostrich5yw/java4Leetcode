package MediumDifficulty;

public class p45 {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return 0;
        for(int i = nums.length - 2;i >= 0;i --){
            if(nums[i] == 0){
                nums[i] = Integer.MAX_VALUE;
                continue;
            }
            if(nums[i] >= nums.length - i - 1){
                nums[i] = 1;
            }else{
                int temp = 100000;
                int len = nums[i];
                for(int j = 1;j <= len;j ++){
                    if(i + j < nums.length && nums[i + j] < temp){
                        temp = nums[i+j];
                    }
                    nums[i] = temp + 1;
                }
            }
        }
        return nums[0];
    }
}
