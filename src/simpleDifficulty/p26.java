package simpleDifficulty;

public class p26 {
    public static void main(String[] args) {
        p26 t = new p26();
        System.out.println(t.removeDuplicates(new int[]{1, 1, 1, 0, 0, -1, 0, -2, 2}));
    }

    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        int i,j;
        for(i = 0;i < nums.length;i ++){
            if(i + 1 < nums.length && nums[i+1] == nums[i]){
                for(j = i + 1;j < nums.length;j ++){
                    nums[j - 1] = nums[j];
                }
                res --;
            }
        }
        for (int p:nums) {
            System.out.println(p);
        }
        return res;
    }
}
