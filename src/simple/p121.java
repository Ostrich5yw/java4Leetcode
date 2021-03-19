package simple;

public class p121 {
    public static void main(String[] args) {
        p121 t = new p121();
        System.out.println(t.maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
        int res = 0;
        int minNum = Integer.MAX_VALUE;
        for(int i = 0;i < prices.length;i ++){
            if(prices[i] < minNum)
                minNum = prices[i];
            else if(prices[i] - minNum > res) {
                res = prices[i] - minNum;
            }
        }
        return res;
    }
}
