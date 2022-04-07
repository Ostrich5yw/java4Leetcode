package middle;

public class p154 {
//    public static void main(String[] args) {
//        test tt = new test();
//        int []nums = new int[]{3,3,3,3,3,3,3,3,1,3};
//        // 3,3,3,3,3,3,3,3,1,3
//        // 2,2,2,0,1
//        // {0,1,2,3,4,5,6,6,6,7,8,9,10,11,12,13,14,0,0,0}
//        // {14,14,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,14,14}
//        // {11,12,13,14,0,1,2,3,4,5,6,7,8,9,10}
//        System.out.println(tt.findMin(nums));
//    }

    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start + 1 < end){
            int mid = (end + start) / 2;
//            System.out.println(nums[start] + " " + nums[mid] + " " + nums[end]);
            if(nums[mid + 1] > nums[end])
                start = mid + 1;
            else if(nums[mid - 1] < nums[start])
                end = mid - 1;
            else if(nums[mid] == nums[start] && nums[mid] == nums[end]){
//                start ++;
                end --;                 //只进行end --  消耗的内存数更少
            }
            else
                return Math.min(nums[start], Math.min(nums[mid], nums[mid + 1]));
        }
        return Math.min(nums[start], nums[end]);
    }
}
