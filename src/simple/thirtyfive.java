package simple;
public class thirtyfive {
    public static void main(String[] args) {
        thirtyfive t = new thirtyfive();
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
