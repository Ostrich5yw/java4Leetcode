package classicalProblem.Sort;

public class insertSort {//insertSort 每次将当前元素插入到前面已经排好序的元素中
    public static int[] insertSort(int[] nums){
        for(int i = 1;i < nums.length;i ++){
            int temp = nums[i];
            int j;
            for(j = i;j > 0;j --){
                if(temp < nums[j - 1])
                    nums[j] = nums[j - 1];
                else
                    break;
            }
            nums[j] = temp;
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = new int[]{3,4,1,7,9,10,111,102,18,32,21,25,24,30,11,17,16, 100,99};
        nums = insertSort(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
