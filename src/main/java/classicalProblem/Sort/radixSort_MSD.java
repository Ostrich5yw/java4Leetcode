package classicalProblem.Sort;

public class radixSort_MSD {    //从高位开始
    public int[] MSDsort(int[] nums, int maxVal){               // maxVal记录数组内最大位数 - 1
        if(maxVal < 0)
            return nums;
        int divNum = (int)Math.pow(10, maxVal);                                         // 除数，322求十位数即是32 / 10 % 10
        int[][] bucket = new int[10][nums.length];
        int[] bucketSize = new int[10];
        for (int i = 0;i < nums.length;i ++){
            int nowDigit = nums[i] / divNum % 10;                                       // 求得最高位
            bucket[nowDigit][bucketSize[nowDigit] ++] = nums[i];                        // 按最高位放入对应桶中
        }
        int t = 0;
        for(int i = 0 ;i < 10;i ++){
            if(bucketSize[i] == 1){
                nums[t++] = bucket[i][0];
            }else if(bucketSize[i] > 1){
                int[] temp = new int[bucketSize[i]];
                System.arraycopy(bucket[i], 0, temp, 0, bucketSize[i]);
                bucket[i] = MSDsort(temp, maxVal - 1);
                for (int j = 0; j < bucketSize[i]; j++) {
                    nums[t++] = bucket[i][j];
                }
            }else
                continue;
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = new int[]{3,4,1,7,9,10,111,102,18,32,21,25,24,30,11,17,16, 100,99};
        int maxVal = -1;
        for(int num : nums)
            maxVal = num > maxVal ? num : maxVal;
        maxVal = (int)Math.log10(maxVal);
        nums = new radixSort_MSD().MSDsort(nums, maxVal);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
