package other;

import java.util.ArrayList;
import java.util.List;

public class six {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
//        int i = 0,j = 0,temp,point = 0;
//        if(numRows == 1)
//             System.out.println(s);
//        int num = (s.length()/(2*numRows-2)+1)*(numRows-1);
//        char[][] cc = new char[numRows][num];
//        String res = "";
//        while(point < s.length()){
//            if((((j) % (numRows-1)) == 0)){
//                if(i == numRows){
//                    i --;
//                    for(temp = 0;temp < numRows-1;temp ++){
//                        i -= 1;
//                        j += 1;
//                        System.out.print(i);
//                        System.out.println(j);
//                        if(point < s.length())
//                            cc[i][j] = s.charAt(point++);
//                    }
//                    i ++;
//                }else{
//                    System.out.print(i);
//                    System.out.println(j);
//                    if(point < s.length())
//                        cc[i][j] = s.charAt(point++);
//                    i += 1;
//                }
//            }
//        }
//        for(i = 0;i < numRows;i ++)
//            for(j = 0;j < num;j ++)
//            {
//                if(cc[i][j] != '\0'){
//                    res += cc[i][j];
//                }
//            }
//        System.out.println(res);
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        StringBuilder res = new StringBuilder();
        int row = 0;
        int i = 0;
        int mark = 1;
        if(numRows == 1)
            System.out.println(0);
        for(i = 0;i < numRows;i ++)
            list.add(new StringBuilder());
        i = 0;
        while(i < s.length()){
            list.get(row).append(s.charAt(i++));
            if(row == numRows-1 || row == 0)
                mark = -mark;
            row += mark;

        }
        for(i = 0;i < numRows;i ++){
            res.append(list.get(i));
        }
        System.out.println(res);
    }
}
