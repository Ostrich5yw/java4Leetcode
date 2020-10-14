package simple;

public class twentyeight {
    public static void main(String[] args) {
        twentyeight t = new twentyeight();
        System.out.println(t.strStr("adddvv", "dvv"));
    }
    public int strStr(String haystack, String needle) {
        int i, j;
        int len = haystack.length() - needle.length() + 1;
        for(i = 0; i < len; i ++){
            int temp = i;
            for(j = 0;j < needle.length();j ++){
                if(haystack.charAt(temp++) != needle.charAt(j)){
                    break;
                }
            }
            if(j == needle.length())
                break;
        }
        if(i >= len)
            return -1;
        return i;
    }
}
