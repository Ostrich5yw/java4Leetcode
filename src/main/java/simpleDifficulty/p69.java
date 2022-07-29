package simpleDifficulty;


public class p69 {
    public static void main(String[] args) {
        p69 t = new p69();
        System.out.println(t.mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        int i = 0, j = x, mid = 0;
        while(i <= j){
//            mid = (i + j) / 2;
            mid = i + (j - i) / 2;          //这样有效避免i + j越界（重要！！！！！）
            if((long)mid * mid == x) break;     //使用long存储，防止越界
            if((long)mid * mid > x){
                j = mid - 1;
            }else
                i = mid + 1;
        }
        return mid * mid > x ? mid - 1:mid;     // 对于8，最后会锁定到3，所以需要返回mid - 1
    }
}
