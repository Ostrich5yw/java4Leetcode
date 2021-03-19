package simple;

public class p122 {
    public static void main(String[] args) {
        p122 t = new p122();
        System.out.println(t.maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
        int total = 0;
        int minNum = prices[0];
        for(int i = 1;i < prices.length;i ++){
//            System.out.println(prices[i] + " " + minNum);
            if(prices[i] - minNum < 0)
                minNum = prices[i];
            else{
                total = total + (prices[i] - minNum);
                minNum = prices[i];
            }
        }
        return total;
    }
}
