package other;

public class nine {
    public static void main(String[] args){
        int x = 4554;
        String s = Integer.toString(x);
        int start = s.length()/2, end = 0;
        if(x < 0) System.out.println(0);
        if(s.length() % 2 == 0){
            end = start;
            start -= 1;
            while(start >= 0)
            {
                if(s.charAt(start) != s.charAt(end))
                    break;
                start --;
                end ++;
            }
        }else{
            end = start +1;
            start = start -1;
            while(start >= 0){
                if(s.charAt(start) != s.charAt(end))
                    break;
                start --;
                end ++;
            }
        }
        System.out.println(start);
    }
}
