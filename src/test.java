import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    ArrayList<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.multiply("11", "987654321"));
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String total = "0";String mark = "";
        int n = num1.length(), m = num2.length();
        for (int i = n - 1; i >= 0;i --) {
            StringBuffer temptotal = new StringBuffer();
            int tempnum1 = num1.charAt(i) - '0';
            int tempproduct;int markproduct = 0;
            for(int j = m - 1;j >= 0;j --){
                int tempnum2 = num2.charAt(j) - '0';
                if(tempnum2 * tempnum1 + markproduct >= 10) {
                    tempproduct = (tempnum2 * tempnum1 + markproduct) % 10;
                    markproduct = (tempnum2 * tempnum1 + markproduct) / 10;
                }else{
                    tempproduct = (tempnum2 * tempnum1 + markproduct);
                    markproduct = 0;
                }
                temptotal.append(tempproduct);
            }
            if (markproduct > 0)
                temptotal.append(markproduct);
            temptotal.reverse();
            temptotal.append(mark);
            mark += "0";
//            System.out.println(temptotal);
            int len1 = total.length() - 1;int len2 = temptotal.length() - 1;int marktotal = 0;
            while(len1 >= 0 || len2 >= 0 || marktotal != 0){
                int totalx = len1 >= 0 ? total.charAt(len1) - '0':0;
                int temptotalx = len2 >= 0 ? temptotal.charAt(len2) - '0':0;
                if(totalx + temptotalx + marktotal >= 10){
                    marktotal = 1;
                }
            }
        }
        return ans;
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
