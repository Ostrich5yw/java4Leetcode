package hardDifficulty;

public class p44 {
    public boolean isMatch(String s, String p) {
        int start = -1;
        int match = 0;
        int i = 0, j = 0;
        for(;i < s.length();){
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
                continue;
            } else if (j < p.length() && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            }else if(start != -1) {
                j = start + 1;
                match += 1;
                i = match;
            }else
                return false;

        }
        for(;j < p.length();j ++){
            if(p.charAt(j) != '*')
                return false;
        }
        return true;
    }
}
