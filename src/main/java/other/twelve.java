package other;

import java.util.HashMap;

public class twelve {
    public static void main(String[] args){
        int num = 1994;

        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        int i;
        String res = "";
        hashmap.put(1,"I");hashmap.put(4,"IV");hashmap.put(5,"V");
        hashmap.put(9,"IX");hashmap.put(10,"X");hashmap.put(40,"XL");
        hashmap.put(50,"L");hashmap.put(90,"XC");hashmap.put(100,"C");
        hashmap.put(400,"CD");hashmap.put(500,"D");hashmap.put(900,"CM");hashmap.put(1000,"M");
        int[] compare = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        while(num != 0){
            for(i = 0;i < compare.length;i ++)
                if(compare[i] > num)
                    break;
            i -= 1;
            num -= compare[i];
            res += hashmap.get(compare[i]);
        }
        System.out.println(res);
    }
}
