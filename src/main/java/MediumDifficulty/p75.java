package MediumDifficulty;

public class p75 {
    public static void main(String[] args) {
        p75 t = new p75();
        t.sortColors(new int[]{0,2});
    }
    public void exchange(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void sortColors(int[] nums) {
        int markzero = 0, marktwo = nums.length - 1;        //题目的要求可以理解为0放在1之前，2放在1之后，所以我们分别吧0和2放在头尾就可以
        int ss = 0;                                         //markzero和marktwo分别记录当前如果找到0和2，该放置的位置
        while(ss <= marktwo){                               //ss作为遍历指针
            /**
             * 注意这里，如果搜索到2，需要循环
             * 比如像2，1，2，2这种情况，ss当前指向0，交换了2，2之后，ss = 0处还是2，但是ss会加一，指向1
             * 所以需要循环交换所有2，也就是说ss不变，marktwo向前遍历，将所有2都放在最后，ss再向下遍历
             * 0不会出现这种情况，因为markzero和ss都是从左至右的
             * **/
            while(nums[ss] == 2 && ss <= marktwo){          //如果当前元素等于2，则将其交换到marktwo，并且marktwo向前一位
                exchange(ss, marktwo, nums);
                marktwo --;
            }
            if(nums[ss] == 0) {                             //如果当前元素等于0，则将其交换到markzero，并且markzero向后一位
                exchange(ss, markzero, nums);
                markzero ++;
            }
            ss ++;
        }
        for(int i:nums){
            System.out.println(i);
        }
    }
}
