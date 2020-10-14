package simple;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class twenty {
    public static void main(String[] args) {
        twenty t = new twenty();
        System.out.println(t.isValid("{[]"));
    }

    public boolean isValid(String s) {
        char temp; int i = 0;
        HashMap<Character, Character> hashmap = new HashMap<>();
        hashmap.put('}', '{');hashmap.put(']', '[');hashmap.put(')', '(');
//        Stack<Character> stack = new Stack<>();
        Deque<Character> stack = new LinkedList<>();                    //Deque即双端队列，既可接受stack也可接受queue
        while(i < s.length()){
            temp = s.charAt(i);
            System.out.println(temp);
            if(temp == '{' || temp == '[' || temp == '('){
                stack.push(temp);
            }else{
                if(stack.isEmpty() || stack.pop() != hashmap.get(temp))         //这里需要判断 }} 这种形式，即当temp存在时且进入了else，stack中必须存在且有与其对应的值
                    return false;
            }
            i ++;
        }
        if(!stack.isEmpty())                                                    //这里判断 { 这种形式
            return false;
        return true;
    }
}
