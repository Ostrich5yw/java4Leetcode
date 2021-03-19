package middle;

/**
 * 折半查找
 *
 * **/
public class p33 {
    public static void main(String[] args) {
        p33 t = new p33();
        System.out.println(t.search(new int[]{1,3}, 2));
    }
    public int search(int[] nums, int target) {
        int p = 0,q = nums.length - 1,mid;
        while(p <= q){
            mid = (p + q) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[p] == target) return p; if(nums[q] == target) return q; if(p == q - 1) return -1;   //三种特殊情况
            /**
             * 分为两类讨论
             * 第一类  ： 3，4，5，6，7，1，2
             * 当中心值大于左端点时
             * 若中心值小于target，则target必出现在中心值右侧
             * 当中心值大于target，且左端点大于target，则target在中心值右侧
             * 当中心值大于target，且左端点小于target，则target在中心值左侧
             * 第二类  ： 6，7，1，2，3，4，5
             * 当中心值小于左端点时。。。。同上
             * **/
            System.out.println(p + " " + q);
            if(nums[mid] > nums[p]){
                if(nums[mid] < target){
                    p = mid + 1;
                }else if(nums[mid] > target && nums[p] > target){
                    p = mid + 1;
                }else if(nums[mid] > target && nums[p] < target){
                    q = mid - 1;
                }}
            else {
                if (nums[mid] > target) {
                    q = mid - 1;
                } else if (nums[mid] < target && nums[q] < target) {
                    q = mid - 1;
                } else if (nums[mid] < target && nums[p] > target) {
                    p = mid + 1;
                }
            }
        }
        return -1;
    }
}

