package hardDifficulty;

import java.util.PriorityQueue;

public class p295 {
    class MedianFinder {
        private PriorityQueue<Integer> max;
        private PriorityQueue<Integer> min;
        public MedianFinder() {
            max = new PriorityQueue<>();
            min = new PriorityQueue<>((a, b)->{return b - a;});
        }

        public void addNum(int num) {
            max.add(num);
            min.add(max.remove());
            if(max.size()<min.size()){
                max.add(min.remove());
            }
        }

        public double findMedian() {
            if(max.size()==min.size()){
                return (max.peek()+min.peek())/2.0;
            }else{
                return max.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
