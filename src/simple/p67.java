package simple;

public class p67 {
    public static void main(String[] args) {
        p67 t = new p67();
        System.out.println(t.addBinary("111", "111"));
    }
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int lena = a.length() - 1;
        int lenb = b.length() - 1;
        int mark = 0;
        while(lena >=0 || lenb >= 0){
            int tempa = lena >= 0 ? a.charAt(lena) - '0':0;     //这两句判断，如果a或b已经遍历完毕而另一方还未遍历完成，则将已经遍历完的置为0
            int tempb = lenb >= 0 ? b.charAt(lenb) - '0':0;     //这样减少了尾部两个while循环
            int  p = tempa + tempb + mark;
            if(p > 1){
                mark = 1;
                res.append((char)(p - 2 +'0'));
            }else{
                mark = 0;
                res.append((char)(p +'0'));
            }
            lena --;
            lenb --;
        }
        if(mark == 1)           //别忘了判断最后一次进位
            res.append((char)(mark + '0'));
        return res.reverse().toString();
    }
}
