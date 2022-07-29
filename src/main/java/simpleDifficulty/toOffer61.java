package simpleDifficulty;

import java.util.Arrays;

public class toOffer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int markZero = 0;
        int oldNum = 0;
        int i = 0;
        for(;i < nums.length;i ++){
            if(nums[i] != 0){
                break;
            }
            markZero ++;
        }
        oldNum = i < nums.length ? nums[i] : 0;
        for(i = i + 1;i < nums.length;i ++){
            int a = Math.abs(nums[i] - oldNum) - 1;
            if(a > markZero || nums[i] == oldNum){
                return false;
            }else{
                markZero = markZero - a;
            }
            oldNum = nums[i];
        }
        return true;
    }

}
