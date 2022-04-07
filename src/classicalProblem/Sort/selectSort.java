package classicalProblem.Sort;

public class selectSort {//selectSort 每次将当前元素替换为后面最小的元素
    public static int[] selectSort(int[] nums){
        for(int i = 0;i < nums.length;i ++){
            int min = nums[i];
            int pos = i;
            for(int j = i + 1;j < nums.length;j ++)
                if(nums[j] < min){
                    pos = j;
                    min = nums[j];
                }
            util.swap(nums, i, pos);
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = new int[]{3,4,1,7,9,10,111,102,18,32,21,25,24,30,11,17,16, 100,99};
        nums = selectSort(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
