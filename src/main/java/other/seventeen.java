package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class seventeen {
    public static void main(String[] args){
        String digits = "23";
        int mark = 0;
        int listlength = 0;
        String temp = "";
        int i, j;
        List<String> list = new ArrayList<>();
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");hashMap.put('3', "def");hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");hashMap.put('6', "mno");hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");hashMap.put('9', "wxyz");
        temp = hashMap.get(digits.charAt(mark++));
        for(i = 0;i < temp.length();i ++)
            list.add(""+temp.charAt(i));
        while(mark < digits.length()){
            temp = hashMap.get(digits.charAt(mark++));
            listlength = temp.length() * list.size();
            int listsize = list.size();
            for(i = 0;i < listsize;i ++) {
                int log = 0;
                String str = list.get(0);
                list.remove(0);
                while(log < temp.length()){
                    list.add(str+temp.charAt(log++));
                }
            }
        }
        System.out.println(list);

    }
}
