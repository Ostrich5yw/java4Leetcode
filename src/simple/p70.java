package simple;


public class p70 {
    private int[] mark = new int[100];              //利用记录数组减少重复运算
    public static void main(String[] args) {
        p70 t = new p70();
        System.out.println(t.climbStairs(4));
    }
    public int climb(int n){
        if(n == 0 || n == 1)
            return 1;
        mark[n - 2] = mark[n - 2] == 0 ? climb(n - 2):mark[n - 2];
        mark[n - 1] = mark[n - 1] == 0 ? climb(n - 1):mark[n - 1];
        return mark[n - 2] + mark[n - 1];
    }
    public int climbStairs(int n) {
        return climb(n);
    }
}
