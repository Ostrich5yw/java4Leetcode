package middle;

/**
 * @author 5yw
 * @date 2022/3/6 19:54
 */
public class p12 {
    public String intToRoman(int num) {
        String res = "";
        int[] temp = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] temp2 = new String[]{"I", "IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        while(num!=0){
            for(int i = 12;i >=0;i --){
                if(num >= temp[i]){
                    int count = num /temp[i];
                    num -= count * temp[i];
                    String word = temp2[i];
                    while(count != 0){
                        res += word;
                        count --;
                    }
                }
            }
        }
        return res;
    }
}
