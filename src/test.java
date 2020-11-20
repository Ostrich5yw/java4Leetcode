import java.util.ArrayList;
import java.util.List;

public class test {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.subsetsWithDup(new int[]{1, 2, 2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        return list;
    }
}