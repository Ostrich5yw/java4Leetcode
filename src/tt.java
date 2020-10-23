import java.util.Arrays;

public class tt {
    public static void main(String[] args){
        int[] n = new int[]{5,4,3,2,1};
        Arrays.sort(n, 1,n.length);
        for(int p:n)
            System.out.println(p);
    }
}
