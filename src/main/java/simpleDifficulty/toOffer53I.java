package simpleDifficulty;

public class toOffer53I {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1 && target == nums[0]){
            return 1;
        }else if(nums.length == 1 && target != nums[0]){
            return 0;
        }
        int lBoarder = 0, rBoarder = 0;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] >= target){
                right = mid - 1;
                lBoarder = right+1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] <= target){
                left = mid + 1;
                rBoarder = left-1;
            }
        }
        if(nums[lBoarder] == target &&  nums[rBoarder] == target)
            return rBoarder - lBoarder + 1;
        else
            return 0;
    }
}
