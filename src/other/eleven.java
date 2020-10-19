package other;

public class eleven {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int len, temp;
        int total = 0;
        int prp;
        for(int i = 0;i < height.length;i ++){
            prp = 0;
            for(int j = height.length - 1;j > i;j --){
                if(height[j] > prp){
                    len = height[i] < height[j]?height[i]:height[j]; //Math.max
//                    System.out.print(i+ " ");
//                    System.out.print(j+ " ");
                    temp = len * (j - i);
//                    System.out.println(temp);
                    total = total > temp?total:temp;
                    prp = height[j];
                }else
                    continue;
            }
        }
        System.out.println(total);
    }
}
