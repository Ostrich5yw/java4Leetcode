package simple;

import java.util.Arrays;

public class p66 {
    public static void main(String[] args) {
        p66 t = new p66();
        System.out.println(t.plusOne(new int[]{1, 9, 9, 9}

        ));
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        int[] res = new int[len + 2];
        int mark = 1;
        while(len >= 0){
            if(digits[len] + mark >= 10){
                res[len + 1] = digits[len] + mark - 10;
                mark = 1;
            }else{
                res[len + 1] = digits[len] + mark;
                mark = 0;
            }
            len --;
        }

        if(mark == 1) {
            res[len + 1] = 1;
//            for(int i = 0;i < res.length;i ++)
//                System.out.print(res[i]);
            return res;
        }

        return Arrays.copyOfRange(res, 0, res.length);
    }
}
