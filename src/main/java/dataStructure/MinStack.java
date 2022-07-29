package dataStructure;
import java.util.ArrayList;

public class MinStack {
    public ArrayList<arrayNum> stack;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.size() == 0)
            stack.add(new arrayNum(val, val));
        else{
            int min = stack.get(stack.size() - 1).minData;
            stack.add(new arrayNum(val, Math.min(min, val)));
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1).data;
    }

    public int getMin() {
        return stack.get(stack.size() - 1).minData;
    }

    class arrayNum{
        int data;
        int minData;
        arrayNum(int data, int minData){
            this.data = data;
            this.minData = minData;
        }
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
