package MediumDifficulty;

public class p55 {
    public static void main(String[] args) {
        p55 t = new p55();
        System.out.println(t.canJump(new int[]{2,3,1,1,4}));
    }
    public boolean canJump(int[] nums) {            //思想：如果可以到达4，则必定可以到达4之前的任意位置
        int maxPos = 0;
        for(int i = 0;i < nums.length;i ++){
            if(i > maxPos)                      //如果连当前位置都到不了，那一定无法走完全程
                return false;
            maxPos = Math.max(maxPos, i + nums[i]); //当前位置可以跳跃到的最大位置与记录的最大位置作比较，得出当前可以跳到的最远位置
            if(maxPos >= nums.length - 1)           //一旦可以到达的位置超过最后一个位置，则必定可以到达最后一个位置
                return true;
        }
        return true;
    }
}
