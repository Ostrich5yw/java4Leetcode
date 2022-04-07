package middle;

public class p153 {
//    public static void main(String[] args) {
//        test tt = new test();
//        int []nums = new int[]{2, 3,4,1};
//        // {1,2,3,4,5,6,7,8,9,10,11,12,13,14,0}
//        // {8,9,10,11,12,13,14,0,1,2,3,4,5,6,7}
//        // {11,12,13,14,0,1,2,3,4,5,6,7,8,9,10}
//        System.out.println(tt.findMin(nums));
//    }

    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start < end){
            if(start == end - 1)
                return Math.min(nums[start], nums[end]);
            int mid = (end + start) / 2;
//            System.out.println(nums[start] + " " + nums[mid] + " " + nums[end]);
            if(nums[mid + 1] > nums[end])
                start = mid + 1;
            else if(nums[mid - 1] < nums[start])
                end = mid - 1;
            else
                return Math.min(nums[start], Math.min(nums[mid], nums[mid + 1]));
        }
//        return mid;
        return nums[0];
    }
}
