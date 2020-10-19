package other;

import java.util.HashMap;

public class thirteen {
    public static void main(String[] args){
        String s = "MCMXCIV";
        int len = s.length(),i = 0;
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        String temp;
        int res = 0;
        hashmap.put("I", 1);hashmap.put("IV", 4);hashmap.put("V", 5);
        hashmap.put("IX", 9);hashmap.put("X", 10);hashmap.put("XL", 40);
        hashmap.put("L", 50);hashmap.put("XC", 90);hashmap.put("C", 100);
        hashmap.put("CD", 400);hashmap.put("D", 500);hashmap.put("CM", 900);hashmap.put("M", 1000);
        while(i < len-1){
            temp = s.substring(i,i+2);
            if(hashmap.containsKey(temp)) {
                res += hashmap.get(temp);
                i += 2;
            } else{
                temp = s.substring(i, i+1);
                res += hashmap.get(temp);
                i += 1;
            }
        }
        if(i == len-1)
            res += hashmap.get(s.substring(i, i+1));
        System.out.println(res);
    }
}
