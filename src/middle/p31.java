package middle;

/**
 * @author 5yw
 * @date 2022/3/24 10:05
 */
public class p31 {
    public void swap(int[] nums, int q, int p){
        int temp = nums[q];
        nums[q] = nums[p];
        nums[p] = temp;
    }
    public void nextPermutation(int[] nums) {  // 5,4,7,5,3,2
        if (nums.length > 1){
            int reverseStart = 0; //开始颠倒顺序的起点，如果nums全倒叙的话就直接从0开始
            for (int i = nums.length-1; i > 0; i--) {
                if (nums[i] > nums[i-1]) { //发现a[i-1] < a[i]的结构
                    reverseStart = i; //记录需要倒叙的起点
                    int minalt = nums[i]; //最接近a[i-1]并且又大于a[i-1]的数字   对于上述数列，即是在索引3的5
                    int minindex = i;
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i-1] && nums[j] <= minalt) {
                            // 这里一定要用小于等于，因为有重复情况的话要swap最靠后的那个nums[]]
                            // 才能确保新的排列是大于原排列最小的那个
                            minalt = nums[j];
                            minindex = j;
                        }
                    }
                    swap(nums, i-1, minindex);//交换a[i-1]与a[k]
                    break;
                }
            }
            for (int i = 0; i < (nums.length-reverseStart)/2; i++) {        //对于交换过后的后半段逆序数组，需要将其正序
                // 把要颠倒排序部分的长度除以二，两两置换
                swap(nums, reverseStart + i, nums.length-i-1);
            }
        }
    }
}
