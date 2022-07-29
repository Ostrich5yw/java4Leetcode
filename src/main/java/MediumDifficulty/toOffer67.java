package MediumDifficulty;

public class toOffer67 {
    public int strToInt(String str) {
        int res = 0;
        if(str.length() == 0){
            return 0;
        }
        char[] ss = str.toCharArray();
        int idx = 0;
        for(;idx < str.length();idx ++){
            if(ss[idx] != ' ')
                break;
        }
        if(idx == str.length() || ((ss[idx] > '9' || ss[idx] < 0) && (ss[idx] != '+' || ss[idx] != '-')))
            return 0;
        int isMinus = 1;
        if(ss[idx] == '-'){
            idx ++;
            isMinus = -1;
        }else if(ss[idx] == '+'){
            idx ++;
        }
        for(;idx < str.length();idx ++){
            if(ss[idx] <= '9' && ss[idx] >= '0'){
                if(Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE - res * 10 < (ss[idx] - '0')){
                    return isMinus == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + (ss[idx] - '0');
            }else{
                break;
            }
        }
        return isMinus * res;
    }

}
