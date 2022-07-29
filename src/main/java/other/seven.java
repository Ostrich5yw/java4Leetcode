package other;

public class seven {
    public static void main(String[] args){
        int x = 1147483648;
//        int conversenum = 0;
//        int temp;
//        boolean mark = false;
//        if(x < 0){
//            x = -x;
//            if(x == -x)
//                System.out.println(0);
//
//            mark = true;
//        }
//        if(x > Integer.MAX_VALUE)
//            System.out.println(0);
//        while(x / 10 != 0){
//            System.out.println(Math.floor(Math.log10(x)));
//            temp = (int)(Math.pow(10, Math.floor(Math.log10(x))));
//            if(Integer.MAX_VALUE / temp < (x % 10))
//                System.out.println(0);
//            conversenum += ((x % 10) * temp);
//
//            x /= 10;
////            if(conversenum >= Integer.MAX_VALUE)
////                System.out.println(0);
//        }
//        conversenum += x;
//        if(mark)
//            conversenum = -conversenum;
//        System.out.println(conversenum);
        int res = 0;
        while(x != 0){
            int temp = x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE && temp > 7)) System.out.println(0);
            if(res < Integer.MIN_VALUE/10 || (res ==Integer.MIN_VALUE && temp < -8)) System.out.println(0);
            res = res*10 + temp;
        }
        System.out.println(res);
    }
}
