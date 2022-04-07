package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 5yw
 * @date 2022/3/15 9:06
 */
public class p22 {
    List<String> res;
    public void recursion(int left, int right, int target, String s){
        if(left == right && s.length() == target){
            res.add(s);
        }
        if(left < target / 2)
            recursion(left + 1, right, target, s + "(");
        if(left > right)
            recursion(left, right + 1, target, s + ")");

    }
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        recursion(1, 0, n * 2, "(");
        return res;
    }
}
