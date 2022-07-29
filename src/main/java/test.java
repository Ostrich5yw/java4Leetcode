import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class test {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] ax = new int[][]{{p1[0], p1[1]}, {p2[0], p2[1]}, {p3[0], p3[1]}, {p4[0], p4[1]}};
        Arrays.sort(ax, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                }else if(o1[0] == o2[0]){
                    if(o1[1] > o2[1]){
                        return 1;
                    }
                    return -1;
                }else{
                    return -1;
                }
            }
        });
        if(!(ax[0][0] == ax[1][0] && ax[0][1] == ax[2][1] && ax[2][0] == ax[3][0] && ax[1][1] == ax[3][1])){
            return false;
        }
        int up = ax[1][1] - ax[0][1], right = ax[3][0] - ax[1][0], down = ax[3][1] - ax[2][1], left = ax[2][0] - ax[0][0];
        if(up != right || up != down || up != left){
            return false;
        }
        return true;
    }
    public static void main(String[] args)  {
        new test().validSquare(new int[]{1, 0},
                new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});
        System.out.println(1);
    }
}