package other;

import java.util.Stack;
public class five {
    public static void main(String[] args){
       String s = "";
       String s1 = "";
       int len = s.length();
       int a[][] = new int[len][len];
       int i,j,l,maxlen=-1;
       for(l = 0; l < len; l ++){
           for (i = 0 ; i < len-l; i ++){
               j = i + l;
               int temp = (s.charAt(i) == s.charAt(j)?1:0);
               if(l == 0) {
                   a[i][j] = 1;
               }else if(l == 1){
                   a[i][j] = temp;
               }else{
                   a[i][j] = (temp+(a[i+1][j-1] == 1?1:0))==2?1:0;
               }
               if((a[i][j] == 1) && (l > maxlen)){
                    s1 = s.substring(i, j+1);
               }
           }
       }
       System.out.println(s1);
    }
}
