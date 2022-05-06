package simpleDifficulty;
public class p35 {
    public static void main(String[] args) {
        p35 t = new p35();
        System.out.println(t.searchInsert(new int[]{1, 2, 4, 5, 6, 8}, 9));
    }
    public int searchInsert(int[] nums, int target) {
        int pos  = 0;
        int len = nums.length;
        while(pos < len){
            if(nums[pos] >= target)
                break;
            pos ++;
        }
        return pos;
    }
}
