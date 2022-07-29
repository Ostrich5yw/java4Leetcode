package MediumDifficulty;

import java.util.ArrayDeque;
import java.util.Deque;

public class toOffer59II {
    class MaxQueue{
        public Deque<Integer> que;
        public Deque<Integer> help;

        public MaxQueue() {
            que = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public int max_value() {
            if(que.size() == 0)
                return -1;
            int val = help.getFirst();
            return val;
        }

        public void push_back(int value) {
            que.addLast(value);
            while(help.size() != 0 && value > help.getLast()){
                help.removeLast();
            }
            help.addLast(value);
        }

        public int pop_front() {
            if(que.size() == 0)
                return -1;
            int val = que.removeFirst();
            if(help.getFirst() == val) {
                help.removeFirst();
            }
            return val;
        }
    }
}
