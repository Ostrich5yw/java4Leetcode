
public class test {
    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.canJump(new int[]{2,3,1,1,4}));
    }
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for(int i = 0;i < nums.length;i ++){
            if(i > maxPos)
                return false;
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return true;
    }
}
