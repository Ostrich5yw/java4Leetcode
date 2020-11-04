
public class test {
    private int[] mark = new int[100];
    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.searchMatrix(new int[][]{
                                    {1, 3, 5, 7},
                                    {10, 11, 16, 20},
                                    {23, 30, 34, 60}
                                  }, 3
        ));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        return true;
    }
}