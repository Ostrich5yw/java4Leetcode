package MediumDifficulty;

public class p50 {
    public double getPow(double x, int leftN, double res){
        if(leftN == 0)
            return res;
        if(leftN == -1)
            return res * x;
        double nowRes = x * x;
        long addN = -2;         // leftN使用负数进行计数，所以addN同样使用负数
        while(addN >= leftN){   //当addN大于leftN，跳出循环。
            addN *= 2;
            nowRes = nowRes * nowRes;
        }
        return getPow(x, leftN - (int)(addN / 2), res * Math.pow(nowRes, 0.5));
        /**
         * 比如n = leftN = -100,x = 2
         * getPow(2, -100, 1)
         * addN加到 -128时，跳出循环，leftN = -100 - (-128 / 2) = -36,res = 1 * 2^64
         * getPow(2, -36, 1 * 2^64)
         * addN加到 -64时，跳出循环，leftN = -36 - (-64 / 2) = -4,res = 1 * 2^64 * 2^32
         * getPow(2, -4, 1 * 2^64 * 2^32)
         * add加到 4 时，跳出循环，leftN = -4 - (-4 / 2) = -2, res = 1 * 2^64 * 2^32 * 2^2
         * getPow(2, -2, 1 * 2^64 * 2^32 * 2^2)
         * add加到 4 时，跳出循环，leftN = -2 - (-2 / 2) = -1, res = 1 * 2^64 * 2^32 * 2^2 * 2^1
         * leftN = -1 ,返回res * 2
         * */
    }
    public double myPow(double x, int n) {
        if(Double.isNaN(x) || x == 0)
            return 0;
        if(n < 0){
            return 1 / getPow(x, n, 1);     //注意此处，考虑到-2147483648的情况，所以leftN使用负数进行计数
        }
        return getPow(x, -n, 1);        // n为正数时，最大2147483647，转为-2147483647也不会溢出
    }
}
