package MediumDifficulty;

import java.util.LinkedList;

public class p151 {
    public String reverseWords(String s) {
//        if(s == "")
//            return s;
        LinkedList<String> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i ++) {                          // i位慢指针，quick为快指针，每次截取i，quick之间的字符串加入栈
            if(s.charAt(i) == ' ')
                continue;
            int quick = i + 1;
            while(quick < s.length() && s.charAt(quick) != ' '){
                quick ++;
            }
            System.out.println(i + " " + quick);
            stack.push(s.substring(i, quick));
            i = quick;
        }


        StringBuilder sb = new StringBuilder();     //依次出栈，完成单词倒序
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
