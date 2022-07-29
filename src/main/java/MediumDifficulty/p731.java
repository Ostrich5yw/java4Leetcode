package MediumDifficulty;

import java.util.ArrayList;
import java.util.List;

public class p731 {
    class MyCalendarTwo {
        List<int[]> book;
        List<int[]> overlap;
        public MyCalendarTwo() {
            book = new ArrayList<>();
            overlap = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for(int[] temp:overlap){
                int l = temp[0];
                int r = temp[1];
                if(l < end &&  r > start){
                    return false;
                }
            }
            for(int[] temp : book){
                int l = temp[0];
                int r = temp[1];
                if(l < end && r > start){
                    overlap.add(new int[]{Math.max(l, start), Math.min(r, end)});
                }
            }
            book.add(new int[]{start, end});
            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
