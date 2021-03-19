package middle;

import java.util.ArrayList;
import java.util.List;

public class p93 {
    List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        p93 t = new p93();
        System.out.println(t.restoreIpAddresses("101023"));    //1.2.3.4.5
    }
    public int findList(String s, int nowPos, String list, int mark){
// s记录给出的字符串，nowPos记录当前遍历到的字符串位置,list记录当前生成的串，mark记录当前生成到第几个数字(一共四个数字，由3个.隔开)
        if(mark > 4)        //101023  如果生成的数字是1.0.1.0.2 遍历到此处，mark已经为5(我们希望s分为4个数字)，直接返回即可
            return 0;
        if(nowPos >= s.length() && mark == 4) {         //如果已经遍历到字符串最后一位之后并且刚好生成了4个数字则说明满足题意
//            list = list.substring(0, list.length() - 1);
            res.add(list);                              //将结果加入返回数组
            return 0;
        }
        for(int i = 1;i <= 3;i ++){ //对于101023，nowPos = 0时，我们将其分为1，10，101三种情况，并依次在第1，2，3位继续向下递归
            if(nowPos + i > s.length())     //如果nowPos向后i位已经超过了s长度，则直接跳出(比如101.0.2.  i=1时得101.0.2.3 i=2时超过s长度，直接跳出)
                return 0;
            int temp = Integer.parseInt(s.substring(nowPos, nowPos + i));
            if(temp >=0 && temp <= 255) {       //如果生成的数字满足0-255，即对于2551111这种，不能生成25.511.1.1这种
                String templist;
                if(mark == 3)                   //如果已经生成了三个数字，最后一个数字生成后不需要在后面加.
                    templist = list + temp;
                else
                    templist = list + temp + ".";
                findList(s, nowPos + i, templist, mark + 1);    //在nowPos+i位继续遍历，且templist新加入一个数字(mark表示templist含有的数字总数)
            }
            if(temp == 0)           //如果101023这种情况，我们会有1.0这种头部，而不会存在1.01这种头部，所以遇到0时只需遍历i=1这一种情况
                return 0;
        }
        return 0;
    }
    public List<String> restoreIpAddresses(String s) {
        findList(s, 0, "", 0);
        return res;
    }
}