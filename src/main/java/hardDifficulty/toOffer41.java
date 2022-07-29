package hardDifficulty;

import java.util.Comparator;
import java.util.PriorityQueue;

public class toOffer41 {
    class MedianFinder {
        PriorityQueue<Integer> smallque;
        PriorityQueue<Integer> bigque;
        /** initialize your data structure here. */
        public MedianFinder() {
            bigque = new PriorityQueue<Integer>(new Comparator<Integer>(){
                @Override
                public int compare(Integer a1, Integer a2){
                    return a2 - a1;
                }
            });
            smallque = new PriorityQueue<Integer>();
        }

        public void addNum(int num) {
            bigque.add(num);
            smallque.add(bigque.remove());
            if(bigque.size() < smallque.size()){
                bigque.add(smallque.remove());
            }
        }

        public double findMedian() {
            if(smallque.size() == bigque.size()){
                return (bigque.peek() + smallque.peek()) / 2.00000;
            }
            return bigque.peek();
        }
    }

}
