package hardDifficulty;

public class toOffer51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }
    public void mergeSort(int[] nums, int left, int right){
        if(left >= right)   return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    public void merge(int[] nums, int left, int mid, int right){
        int[] numsTemp = new int[right - left + 1];
        int pointTemp = 0, pointR = mid + 1, pointL = left;
        while(pointL <= mid || pointR <= right){
            if(pointR > right || pointL > mid){
                while(pointL <= mid){
                    numsTemp[pointTemp++] = nums[pointL ++];
                }
                while(pointR <= right){
                    numsTemp[pointTemp++] = nums[pointR ++];
                }
                break;
            }
            if(nums[pointL] > nums[pointR]){
                count += (mid - pointL + 1);
                numsTemp[pointTemp ++] = nums[pointR++];
            }else{
                numsTemp[pointTemp ++] = nums[pointL++];
            }
        }
        for(int i = left;i <= right;i ++){
            nums[i] = numsTemp[i - left];
        }
    }
}
