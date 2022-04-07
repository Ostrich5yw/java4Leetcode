package simple;

/**
 * @author 5yw
 * @date 2021/11/23 8:45
 */
public class p283 {
    public void moveZeroes(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                num++;
                continue;
            }
            nums[i-num] = nums[i];
        }
        for(int i = nums.length - num;i < nums.length;i++){
            nums[i] = 0;
        }
    }
}
