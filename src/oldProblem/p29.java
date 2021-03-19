package oldProblem;

/**
 *          寻找最大的商(不能用乘除法)
 *          转化为对于100/3    从3开始 现有3+3=6 < 100 --> 6+6=12 < 100 --> 12+12=24 < 100 -->...--> 48+48 < 100 -->96+96 = 192>100
 *                           从96开始 96+3=99 < 100 --> 99 + 6 ==105 >100
 *           递归问题
 *
 *
 *
 *
 *
 * **/
public class p29 {
    public static void main(String[] args) {
        p29 t = new p29();
        System.out.println(t.divide(Integer.MAX_VALUE, 3));
    }

    public int getLowline(int lowline, int marklow,int dividend, int divisor){
        int temp = 1;           //1,2,4,8...
        int templine;
        int res;
        if(lowline == dividend || lowline + divisor < dividend || lowline + divisor >= 0)      //当下界等于被除数或下界和上界只差1个除数时，说明下界的商已经是最大的商了
            return marklow;                                                  //最后一种情况是考虑dividend=MAX_value时，lowline再加可能越界，则也说明商已经为最大

        // 对于100/3     现有3+3=6 < 100 --> 6+6=12 < 100 --> 12+12=24 < 100 -->...--> 48+48 < 100 --> 96+96 > 100 跳出循环
        //此时templine记录96，lowline更新为192， marklow记录64
        //于是递归进入下一阶段，在96和192之间继续寻找逼近100的上下界

        templine = lowline;
        while(lowline >= dividend && lowline < 0){
            templine = lowline;
            lowline += divisor * temp;      //每次加的都为上一次的2倍
            marklow += (temp ++);           //marklow记录当前lowline是divisor的多少倍
        }
        res = getLowline(templine, marklow - temp + 1,dividend, divisor);
        return res;
    }
    public int divide(int dividend, int divisor) {
        int res;
        int mark = 0;
        //排除特殊情况
        if((divisor > -1 && divisor < 1) || (divisor == -1 && dividend == Integer.MIN_VALUE))
            return Integer.MAX_VALUE;
        if((Math.abs(divisor) == 1 && dividend == Integer.MIN_VALUE))
            return Integer.MIN_VALUE;

        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))      //mark记录二者相除的结果为正还是为负
            mark = 1;
        dividend = dividend > 0 ? -dividend:dividend;       //因为负数可表示的范围比正数大1，所以把二者都存为负数，才可以计算dividend=MIN_VALUE的情况
        divisor = divisor > 0 ? -divisor:divisor;
        //这也是特殊情况
        if(dividend > divisor)
            return 0;
        if(mark == 1)           //getlowline返回的均为正数，所以根据mark将res赋为正或负
            res = getLowline((divisor) , 1, (dividend), (divisor));
        else
            res = -getLowline((divisor), 1, (dividend), (divisor));
        return res;
    }
}
