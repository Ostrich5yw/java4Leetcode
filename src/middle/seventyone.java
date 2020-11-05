package middle;

import java.util.Stack;
/**
 * subString---------------------4ms
 * 字符串拼接---------------------12ms
 * **/
public class seventyone {
    public static void main(String[] args) {
        seventyone t = new seventyone();
        System.out.println(t.simplifyPath("/home/ho/"));
    }
    public String simplifyPath(String path) {
        String res = "";
        Stack s = new Stack();
        for(int i = 0;i < path.length();i ++){      //从头开始遍历String
            char nowChar = path.charAt(i);
            if(nowChar == '/'){                 //遍历到/说明即将要开始一个目录字符串
                while(i < path.length() && path.charAt(i) == '/') i ++;  //可能会有很多重复的/，所以遍历掉这些重复的/
                String word = "";                                        //注意当最后一个字符是/时，也会进入if内，并且word的值为“”
//               while(i < path.length() && path.charAt(i) != '/'){       //所以下方还需要判断word!=""
//                   word += path.charAt(i);      //将目录字符串存入word
//                   i ++;
//               }
                /**
                 *  同样是循环找到当前目录字符串截止位置，但是使用substring函数，要比每次拼接字符串快很多。
                 * **/
                int p = i;
                while(i < path.length() && path.charAt(i) != '/'){
                    i ++;
                }
                word = path.substring(p, i);
                if(!word.equals("..") && !word.equals(".") && !word.equals(""))   //当这个目录是一个有效目录，则将它推入栈中
                    s.push('/' + word);
                if(word.equals("..") && !s.isEmpty())            //如果是..  且栈非空，则出栈一个元素
                    s.pop();
                i --;            //因为for循环还要加1，所以这里提前-1，这样新一轮的遍历就会从这个目录字符串的下一位开始了
            }
        }
        /**
         * 如果输入是/a/b/c
         * 那么栈中存放的应该是   /a   /b   /c（此为栈顶）
         * 所以需要依次出栈并且每次把新出栈的元素加到res之前
         * **/
        while(!s.isEmpty()){
            String temp = String.valueOf(s.pop());

            res = temp + res;
        }
        if(res.length() == 0)
            return "/";
        return res;
    }
}

