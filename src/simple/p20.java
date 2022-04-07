package simple;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class p20 {
    public static void main(String[] args) {
        p20 t = new p20();
        System.out.println(t.isValid("{[]"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{', '}');
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0;i < s.length();i ++){
            if(!stack.isEmpty() && hashMap.get(stack.peek()) == s.charAt(i)){   //如果与栈顶元素对应，则出栈栈顶元素，继续下一个
                stack.pop();
            }else {
                if(!hashMap.containsKey(s.charAt(i))){  //如果不对应，且是})]中的一个，直接false
                    return false;
                }
                stack.push(s.charAt(i));        //否则入栈
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
