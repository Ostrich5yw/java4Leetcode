package simple;

public class p58 {
    public static void main(String[] args) {
        p58 t = new p58();
        System.out.println(t.lengthOfLastWord(new String(" hell ")));
    }
    public int lengthOfLastWord(String s) {
        int res = 0;
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' ') //从后至前进行遍历，首先过滤掉由后至前的空格(注意数组中可能全是空格或首个字符是空格时会越界，所以要判断大于等于0)
            i --;
        while(i >= 0){
            if(s.charAt(i) == ' ')              //当遇到空格时，res记录的就是最后一个单词的长度，直接break
                break;
            i --;
            res ++;
        }
//        System.out.println(res);
        return res;
    }
}

