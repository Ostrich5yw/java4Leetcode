package hardDifficulty;

import java.util.Comparator;
import java.util.PriorityQueue;

public class toOffer59I {
    class Num{
        int pos;
        int val;
        public Num(int pos, int val){
            this.pos = pos;
            this.val = val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int recPos = 0;
        int left = 0, right = 0;
        int nLen = nums.length;
        if(nLen == 0){
            return new int[]{};
        }
        PriorityQueue<Num> pq = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                if(o1.val > o2.val){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        while(right < nLen){
            Num num = new Num(right, nums[right]);
            pq.add(num);
            if(right - left >= k){
                for(Num p : pq){
                    if(p.pos == left){
                        pq.remove(p);
                        left ++;
                        break;
                    }
                }
            }
            if(right - left == k - 1)
                res[recPos++] = pq.peek().val;
            right ++;
        }
        return res;
    }
}
