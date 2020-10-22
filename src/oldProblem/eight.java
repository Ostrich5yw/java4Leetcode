package oldProblem;

public class eight {
    public static void main(String[] args){
        String s = "12313";
        int i = 0,j;
        char a;
        int res = 0,mark = 0;
        while(i < s.length()) {
            a = s.charAt(i);
            if((a == '+' || a == '-') && (i+1<s.length()))
                if(s.charAt(i+1) > '9'|| s.charAt(i+1) <'0')
                    System.out.println(0);
            if (a == '+' || a == '-' || (a >= '0' && a <= '9'))
                break;
            else if (a == ' ') {
                i++;
                continue;
            }
            else
                System.out.println(1);
        }
        j = s.length() - 1;
        while(j > i){
            a = s.charAt(j);
//          System.out.println(a);
            if(a >= '0' && a <= '9') {
                System.out.print(res);
                System.out.print("   ");

                System.out.println((Integer.MAX_VALUE-((int)Math.pow(10, mark)) * (a - '0')));

                if((Integer.MAX_VALUE-((int)Math.pow(10, mark)) * (a - '0')) < res || (mark > 8 && (a - '0') > 2) )
                    if(s.charAt(i) == '-')
                        System.out.println(Integer.MIN_VALUE);
                    else
                        System.out.println(Integer.MAX_VALUE);                res += ((int)Math.pow(10, mark)) * (a - '0');
                mark ++;
            }else{
                res = 0;
                mark = 0;
            }
            j --;
        }
        if(s.length() == 0 || i >= s.length())
            System.out.println(2);
        if(s.charAt(i) == '-'){
            res = -res;
        }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if((Integer.MAX_VALUE-((int)Math.pow(10, mark)) * (s.charAt(i) - '0')) < res)
                if(s.charAt(i) == '-')
                    System.out.println(Integer.MIN_VALUE);
                else
                    System.out.println(Integer.MAX_VALUE);
            res += ((int)Math.pow(10, mark)) * (s.charAt(i) - '0');
        }else
            res = res;
        System.out.println(res);
    }
}
