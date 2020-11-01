import java.util.Arrays;
import java.util.Comparator;

public class tt {
    public static void main(String[] args){
        int[][] n = new int[][]{{3,2},{2,1},{1,2}};
        Arrays.sort(n, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 1;
            }
        });
        for(int[] p:n)
            System.out.println(p[0]+ " " + p[1]);
    }
}
