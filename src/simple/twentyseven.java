package simple;

public class twentyseven {
    public static void main(String[] args){
        twentyseven t = new twentyseven();
        System.out.println(t.removeElement(new int[]{1, 1, 1, 0, 0, -1, 0, -2, 2}, 1));
    }
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int p;
        for(p = 0;p < nums.length;p ++){
            if(nums[p] != val){
                nums[res] = nums[p];
                res ++;
            }
        }
        return res;
    }
}
