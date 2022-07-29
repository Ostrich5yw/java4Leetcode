package MediumDifficulty;

public class toOffer46 {class Solution {
    int res;
    public int dfs(String num, int pos){
        if(pos >= num.length() - 1){
            res += 1;
            return 0;
        }
        int temp = 0;
        if(pos + 2 <= num.length())
            temp = Integer.parseInt(num.substring(pos, pos + 2));
        dfs(num, pos + 1);
        if(temp >= 10 && temp <= 25)
            dfs(num, pos + 2);
        return 0;
    }
    public int translateNum(int num) {
        res = 0;
        dfs(String.valueOf(num), 0);
        return res;
    }
}

}
