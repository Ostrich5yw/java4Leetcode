package classicalProblem.Sort;

public class radixSort_LSD {        //从低位开始
    public int[] LSDsort(int[] nums){
        int maxVal = -1;
        for(int num : nums)
            maxVal = num > maxVal ? num : maxVal;
        maxVal = (int)Math.log10(maxVal);
        maxVal = (int)Math.pow(10 , maxVal + 1);
        int m = 10;
        while(m <= maxVal){
            int[][] bucket = new int[10][nums.length];
            int[] bucketSize = new int[10];
            for (int i = 0;i < nums.length;i ++){
                int nowDigit = (nums[i]) % m / (m/10);
                bucket[nowDigit][bucketSize[nowDigit] ++] = nums[i];
            }
            int t = 0;
            for(int i = 0 ;i < 10;i ++){
                for(int j = 0; j < bucketSize[i];j ++){
                    nums[t ++] = bucket[i][j];
                }
            }
            m = m * 10;
        }
        for(int i : nums){
            System.out.print(i + " ");
        }
        return nums;
    }
    public static void main(String[] args){
        new radixSort_LSD().LSDsort(new int[]{3,4,1,7,9,10,18,32,21,25,24,30,11,17,16});
    }
}
