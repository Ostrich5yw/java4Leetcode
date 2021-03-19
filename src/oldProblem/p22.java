package oldProblem;
import java.util.*;


public class p22 {
    public static void main(String[] args) {
        p22 t = new p22();
        List<String> list = t.generateParenthesis(5);
        System.out.println(list);
    }
    //rulenum记录(的数量，layer记录当前走到哪一位，s记录当前字符串，list保存满足条件的字符串，n作为参数
    public int findpath(int rulenum, int layer, String s, List<String> list,int n){
        if(layer == n * 2 && rulenum == 0) {            //走到最后一位并且()括号数相同
            list.add(s);
            return 0;
        }
        if(rulenum < 0 || layer == n * 2){              //走到最后且()括号数不同或者当前)括号数大于(括号数 则返回
            return 0;
        }
        findpath(rulenum + 1, layer + 1, s + '(', list, n);     //尝试加一个(或一个)
        findpath(rulenum - 1, layer + 1, s + ')', list, n);
        return 0;
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0)
            return list;
        findpath(1, 1, "(", list, n);
        return list;
    }
}
