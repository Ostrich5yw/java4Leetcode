package MediumDifficulty;

/**
 * @author 5yw
 * @date 2022/3/4 15:40
 */
public class p8 {
    public int myAtoi(String s) {
        char[] ca = s.toCharArray();
        int i = 0;
        int mark = 1;
        while(i < ca.length && ca[i] == ' '){
            i ++;
        }
        if(i >= ca.length){
            return 0;
        }else if(ca[i] == '-'){
            mark = -1;
            i ++;
        }else if(ca[i] == '+'){
            i ++;
        }else if(!Character.isDigit(ca[i])){
            return 0;
        }
        int res = 0;
        while(i < ca.length && Character.isDigit(ca[i])){
            int nowNum = ca[i] - '0';
            if(mark == 1){
                if((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && nowNum > 7)){
                    return Integer.MAX_VALUE;
                }
            }else{
                if((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && nowNum > 8)){
                    return Integer.MIN_VALUE;
                }
            }
            res = res * 10 + nowNum;
            i++;
        }
        return mark == -1 ? -res:res;
    }
}
