package oldProblem;

public class ninetyone {
    public static void main(String[] args) {
        ninetyone t = new ninetyone();
        System.out.println(t.numDecodings("9006"));
    }
    /**
     * 动态规划
     * 对于11111  我们看第五个1，它可以与之前的1组成11，也可以单独作为1
     * 所以第五个1可以构成的数量就是前3个1的组合数量 + 前4个的组合数量  ，即dp[i] = dp[i-1] + dp[i-2]
     * **/
    public int numDecodings(String s) {
        if((s.length() == 0 || s.charAt(0) == '0'))     //当第一个为0或者长度为0，直接返回0
            return 0;
        if(s.length() == 1)                             //长度为1直接返回1
            return 1;
        int[] dp = new int[s.length()];         //建立dp数组

        //初始化前两个dp的值
        dp[0] = 1;
        if(s.charAt(1) == '0') {      //这个需要放在第二个判断之前，因为10，20实际上只有1种分配方式，但他也会进入第二个判断，所以把这个判断放在前面，防止误判
            if(Integer.parseInt(s.substring(0,2)) <= 26) //如果是10，20，则为1
                dp[1] = 1;
            else                                        //如果是30，40...则为0
                dp[1] = 0;
        }else if(Integer.parseInt(s.substring(0,2)) <= 26)  //25这种
            dp[1] = 2;
        else                                                //61这种
            dp[1] = 1;


        for(int i = 2;i < s.length();i ++){
            int i1 = Integer.parseInt(s.substring(i - 1, i + 1));   //这个记录当前位与它的前一位组合生成的数字
            if(s.charAt(i) == '0'){                         //如果当前位为0
                if(i1 > 26 || i1 == 0)                      //与他前一位组成60，00这种，直接返回0
                    return 0;
                dp[i] = dp[i - 2];                          //10，20
            }else if(s.charAt(i - 1) != '0' && i1 <= 26){   // 21，25这种，但要排除01，02这种
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {                                         //67这种
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
    /**
     * 递归太慢，但这种return a + b 的思路要记住
     * **/
//    public int getNum(String s, int nowPos){
//        int a = 0, b = 0;
//        if(nowPos == s.length())
//            return 1;
//        if(s.charAt(nowPos) - '0' > 0) {
//                if (nowPos + 1 < s.length() && Integer.parseInt(s.substring(nowPos, nowPos + 2)) <= 26) {
//                    a = getNum(s, nowPos + 2);
//                }
//                b = getNum(s, nowPos + 1);
//                return a + b;
//        }
//        return 0;
//    }
//    public int numDecodings(String s) {
//        if(s.length() == 0)
//            return 0;
//        return getNum(s, 0);
//    }
}
