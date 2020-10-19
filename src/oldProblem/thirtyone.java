package oldProblem;
import java.util.Arrays;


/**
 * 观察规律，首先由后至前查找，如果有一个值，左边小于它，右边小于等于它，则将这个位置往后最小的一个数找出，
 * 并与它左边的数交换，之后对它及之后的值进行由小到大排序
 *
 * 之后，如果有一个值，左边小于它，则直接将两个数的位置交换
 *
 * 如果遍历到第一个值依旧没有交换，则认为该值最大，按题目要求返回最小值
 * **/
public class thirtyone {
    public static void main(String[] args) {
        thirtyone t = new thirtyone();
        t.nextPermutation(new int[]{4,2,4,4,3});
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length - 1,tlen = len;           // len为循环变量，tlen始终记录数组长度
        while(len > 0){
            if(len <= tlen - 1 && nums[len - 1] < nums[len] && nums[len + 1] <= nums[len]){
                int mark = len;             //mark记录len及其之后，大于len-1的最小值
                for(int i = len;i < nums.length;i ++){
                    if(nums[i] > nums[len - 1] && nums[i] < nums[mark])
                        mark = i;
                }
                int temp = nums[len - 1];           //交换mark与len-1位置
                nums[len - 1] = nums[mark];
                nums[mark] = temp;
                Arrays.sort(nums, len , nums.length);       // len之后的数组重新排序
                break;
            }
            if(nums[len - 1] < nums[len]){              //必须放在第一个条件之后
                int temp = nums[len - 1];
                nums[len - 1] = nums[len];
                nums[len] = temp;
                break;
            }
            len --;
        }
        if(len == 0)                        //len==0说明未发生交换，将数组由小到大排序
            Arrays.sort(nums, 0, nums.length);
        for (int n:nums) {
            System.out.println(n);
        }
    }
}

