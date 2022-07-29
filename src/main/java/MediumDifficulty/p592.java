package MediumDifficulty;

public class p592 {
    long resUp = 0;
    long resDown = 1;
    public long gcd(long a, long b) {
        if (a < 0 || b < 0) return gcd(Math.abs(a), Math.abs(b));
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public long find(long a, long b){
        long temp = a;
        while(a % b != 0){
            a += temp;
        }
        return a;
    }
    public int getRes(char[] cc, int i, long mark){
        String nowUp = "", nowDown = "";
        while(cc[i] != '/'){
            nowUp += cc[i++];
        }
        i ++;
        while(i < cc.length && (cc[i] != '-' && cc[i] != '+')){
            nowDown += cc[i++];
        }
        long up = Integer.parseInt(nowUp);
        long down = Integer.parseInt(nowDown);
        long newDown = find(resDown, down);
        resUp = resUp * (newDown / resDown) + mark * up * (newDown / down);
        resDown = newDown;
        return i;
    }
    public String fractionAddition(String expression) {
        char[] cc = expression.toCharArray();
        for(int i = 0;i < cc.length;){
            if(cc[i] == '-'){
                i = getRes(cc, i + 1, -1);
            }else if(cc[i] == '+'){
                i = getRes(cc, i + 1, 1);
            }else{
                i = getRes(cc, i, 1);
            }
        }
        if(resUp == '0'){
            return resUp + "/" + 1;
        }
        long gcd = gcd(resUp, resDown);
        return resUp / gcd + "/" + resDown / gcd;
    }
}
