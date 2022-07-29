package MediumDifficulty;

/**
 * @author 5yw
 * @date 2022/3/22 9:57
 */
public class p29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int res = 0;
        int mark = (dividend ^ divisor) < 0 ? -1 : 1;
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        while (divisor1 <= dividend1){
            long tRes = 1, tDivisor = divisor1;
            while (tDivisor < dividend1 >> 1){
                tDivisor = tDivisor << 1;
                tRes = tRes * 2;
            }
            dividend1 -= tDivisor;
            res += tRes;
        }
        return mark * res;
    }
}
