package MediumDifficulty;

/**
 * @author 5yw
 * @date 2022/3/2 9:18
 */
public class p5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int begin = 0, maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0;i < len;i ++){            //所有长度为1的子串都是回文串，所有长度为2且元素相同的都是回文串
            dp[i][i] = true;
            if(i+1 < len && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                begin = i;maxLen = 2;
            }else if(i+1 < len)
                dp[i][i+1] = false;
        }
        for(int subLen = 2;subLen < len;subLen ++){     //为可以利用之前的dp值，因此每一轮计算所有起始点向后相同长度的子串的dp值
            for(int i = 0;i < len;i ++){
                int j = i + subLen;
                if(j >= len){
                    break;
                }
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(maxLen < j - i + 1){
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
