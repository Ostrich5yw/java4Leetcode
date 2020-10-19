package simple;

import java.util.ArrayList;
import java.util.List;

public class thirtyeight {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        thirtyeight t = new thirtyeight();
        System.out.println(t.countAndSay(5));
    }
    public String countAndSay(int n) {
        String res = "1";String tempres = "";
        int i,len;
        int num;char mark;
        for(i = 1;i < n;i ++){
            /**
             * res记录参考字符串
             * tempres记录参考字符串得出的结果字符串   ，每一次循环之后，再将tempres作为新的参考字符串赋给res
             * len记录参考字符串长度
             * **/
            len = res.length();
            num = 1;                        //num记录相同字符个数
            mark = res.charAt(len - 1);     //mark记录重复字符
            tempres = "";
            len--;                          //mark初始化为len-1，所以遍历需要从len-2开始
            while(--len >= 0){
                if(mark != res.charAt(len)){
                    //当记录重复字符与当前字符不一致时，更新mark和num的值，并将其加入tempres之前（因为是从后向前遍历）
                    tempres = String.valueOf(num) + mark + tempres;
                    mark = res.charAt(len);
                    num = 1;
                }else
                    num ++;
            }
            //由于遍历到0位置直接跳出，所以需要将最后一次的mark和num手动加入tempres字符串
            tempres = String.valueOf(num) + mark + tempres;
            res = tempres;
        }
        return res;
    }
}

