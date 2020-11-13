package oldProblem;


public class eightyone {
    public static void main(String[] args) {
        eightyone t = new eightyone();
        System.out.println(t.search(new int[]{1,3,1,1,1}, 3));
    }
    public boolean search(int[] nums, int target) {
        int p = 0,q = nums.length - 1,mid;
        while(p <= q){
            mid = (p + q) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[p] == target) return true; if(nums[q] == target) return true; if(p == q - 1) return false;   //三种特殊情况
            /**
             * 分为三类讨论
             * 第一类  ： 3，4，5，6，7，1，2
             * 当中心值大于左端点时
             * 若中心值小于target，则target必出现在中心值右侧
             * 当中心值大于target，且左端点大于target，则target在中心值右侧
             * 当中心值大于target，且左端点小于target，则target在中心值左侧
             * 第二类  ： 6，7，1，2，3，4，5
             * 当中心值小于左端点时。。。。同上
             *
             * 第三类：1，3，1，1，1
             * 当中心值等于左端点时
             * 对于这类，我们只需让左指针p向右1位，即去掉一个干扰项
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
            else if(nums[mid] < nums[p]){
                if (nums[mid] > target) {
                    q = mid - 1;
                } else if (nums[mid] < target && nums[q] < target) {
                    q = mid - 1;
                } else if (nums[mid] < target && nums[p] > target) {
                    p = mid + 1;
                }
            }else{
                p ++;
            }
        }
        return false;
    }
}
