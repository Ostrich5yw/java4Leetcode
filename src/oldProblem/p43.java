package oldProblem;

/**
 * 大数加法and大数乘法
 *  12345 * 12345 进行竖式乘法
 *
 *  首先取num1中的5与num2各位相乘的带temptotal
 *  依次再取num1中的4，3，2，1 将这些temptotal相加得到total
 *
 *  注意乘法与加法都需要转char保存，因为都有可能越界
 * **/

public class p43 {
    public static void main(String[] args) {
        p43 t = new p43();
        System.out.println(t.multiply("123456789", "987654321"));
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String total = "0";String mark = "";
        int n = num1.length(), m = num2.length();
        for (int i = n - 1; i >= 0;i --) {                      //num1由低位到高位遍历
            /**
             *  大数乘法
             * **/
            StringBuffer temptotal = new StringBuffer();        //temptotal存放num1该位与num2的乘积
            int tempnum1 = num1.charAt(i) - '0';
            int tempproduct;int markproduct = 0;  //tempproduct暂时保存num1某位与num2某位乘积的个位，markproduct保存乘积的十位
            for(int j = m - 1;j >= 0;j --){
                int tempnum2 = num2.charAt(j) - '0';    //tempnum1与tempnum2分别保存num1与num2的某一位
                if(tempnum2 * tempnum1 + markproduct >= 10) {                   //若乘积加进位大于10
                    tempproduct = (tempnum2 * tempnum1 + markproduct) % 10;         //7 * 8 =56   则tempproduct = 6,markproduct = 5
                    markproduct = (tempnum2 * tempnum1 + markproduct) / 10;
                }else{
                    tempproduct = (tempnum2 * tempnum1 + markproduct);
                    markproduct = 0;
                }
                temptotal.append(tempproduct);
            }
            if (markproduct > 0)                    //别忘了最后一个进位
                temptotal.append(markproduct);
            temptotal.reverse();                    //append导致string数组与结果相反，所以要反转回来
            temptotal.append(mark);                 //123*123   当num1的2与num2相乘时，结果需要加0，num1的1与num2相乘时，结果需要加00
            mark += "0";                            //方便之后相加
//            System.out.println(temptotal);
            /**
             *  大数加法
             * **/
            int len1 = total.length() - 1;int len2 = temptotal.length() - 1;int marktotal = 0;
            StringBuffer tt = new StringBuffer();           //tt暂时保存total与temptotal的和，并在加完之后再次赋给total
            while(len1 >= 0 || len2 >= 0 || marktotal != 0){                //这种写法是我下面写法的改进，省了两个while循环和最后进位判断
                int totalx = len1 >= 0 ? total.charAt(len1) - '0':0;
                int temptotalx = len2 >= 0 ? temptotal.charAt(len2) - '0':0;
                if(totalx + temptotalx + marktotal >= 10){                  //保存加法的进位，并将结果的个位数添加到暂存数组tt中
                    tt.append(totalx + temptotalx + marktotal - 10);
                    marktotal = 1;
                }else{
                    tt.append(totalx + temptotalx + marktotal);
                    marktotal = 0;
                }
                len1 --;
                len2 --;
            }
            total = tt.reverse().toString();
//            System.out.println(tt);
        }
        return total;
    }


//    public String multiply(String num1, String num2) {
//        int i, j;
//        String total = "0";int totalpos = 0;String temptotal = "";int pos;String mark = "";
//        int len1,len2;
//        int sum;int m = 0;
//        if(num1.equals("0") || num2.equals("0"))
//            return "0";
//        for (i = num1.length() - 1;i >= 0 ;i --){
//            int num3 = num1.charAt(i) - '0';
//            temptotal = "";pos = 0;
//            int markproduct = 0;int tempproduct;
//            for (j = num2.length() - 1;j >= 0 ;j --) {
//                int temp = num2.charAt(j) - '0';
//                tempproduct = temp * num3 + markproduct >= 10 ?  (temp * num3 + markproduct)%10 : temp * num3 + markproduct;
//                markproduct = temp * num3 + markproduct >= 10 ?  (temp * num3 + markproduct)/10 : 0;
////                System.out.println(tempproduct + " "+ markproduct);
//                temptotal = (char)(tempproduct + '0') + temptotal;
//            }
//            if(markproduct!=0)
//                temptotal = (char)(markproduct + '0') + temptotal;
////            System.out.println(temptotal);
//            String temp;
//            if (temptotal == "0")
//                temp = (temptotal);
//            else
//                temp = (temptotal) + mark;
//            mark += "0";
//            len1 = total.length() - 1;len2 = temp.length() - 1;
//            m = 0;
//            String newtotal = "";
//            while(len1 >= 0 && len2 >= 0){
//                sum = (total.charAt(len1)-'0') + (temp.charAt(len2) - '0') + m;
//                if(sum >= 10){
//                    sum -= 10;
//                    m = 1;
//                }else
//                    m=0;
//                newtotal = (char)(sum+'0') + newtotal;
//                len1--;len2--;
//            }
//            while(len1 >= 0) {
//                sum = (total.charAt(len1)-'0') + m;
//                if(sum >= 10){
//                    sum -= 10;
//                    m = 1;
//                }else
//                    m=0;
//                newtotal = (char)(sum+'0') + newtotal;
//                len1 --;
//            }
//            while(len2 >= 0){
//                sum = (temp.charAt(len2)-'0') + m;
//                if(sum >= 10){
//                    sum -= 10;
//                    m = 1;
//                }else
//                    m=0;
//                newtotal = (char)(sum+'0') + newtotal;
//                len2 --;
//            }
//            if(m!=0)
//                newtotal=(char)(m+'0') + newtotal;
//            total = newtotal;
//        }
//        return String.valueOf(total);
//    }
}

