package middle;
public class thirtyfour {
    public static void main(String[] args) {
        thirtyfour t = new thirtyfour();
        System.out.print(t.searchRange(new int[]{5,7,7,8,8,10},6)[0] + " ");
        System.out.println(t.searchRange(new int[]{5,7,7,8,8,10},6)[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int p = 0,q = nums.length - 1,mid;
        int markleft = -1, markright = -1;
        while(p <= q){
            mid = (p + q) / 2;
            if(nums[mid] == target) {
                markleft = mid;
                q = mid - 1;
            }else if(nums[mid] > target){
                q = mid - 1;
            }else
                p = mid + 1;
        }
        p = 0; q = nums.length - 1;
        while(p <= q){
            mid = (p + q) / 2;
            if(nums[mid] == target) {
                markright = mid;
                p = mid + 1;
            }else if(nums[mid] > target){
                q = mid - 1;
            }else
                p = mid + 1;
        }
        res[0] = markleft;
        res[1] = markright;
        return res;
    }
}
