package middle;

public class p74 {
    private int[] mark = new int[100];
    public static void main(String[] args) {
        p74 t = new p74();
        System.out.println(t.searchMatrix(new int[][]{
                        {1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,50}
                }, 30
        ));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;        //如果二维数组为空，或者为{{}}则必不包含目标元素
        if(matrix[0].length == 0) return false;
        int lencol = matrix.length;
        int lenarr = matrix[0].length;
        int targetcol = 0;                  //先定位元素最可能的所在行，再遍历该行
        if(matrix[targetcol][0] > target) return false;     //如果目标还没有0，0处的元素大，则矩阵内肯定不包含目标
        for(targetcol = 1;targetcol < lencol;targetcol ++){
            /**
             * 行首元素等于目标元素，则直接返回true
             * 否则一直找到比目标元素大的行首元素，则目标元素一定在他的上一行
             * 若遍历到最后一行仍小于目标元素，则目标元素若在矩阵内，则只可能在最后一行
             * **/
            if(matrix[targetcol][0] == target)  return true;
            if(matrix[targetcol][0] > target){
                break;
            }
            if(targetcol == lencol - 1) {
                targetcol += 1;             //因为外面会为其减一。所以这里先加一，保证列遍历时，targetcol指向最后一行
                break;
            }
        }
        targetcol -= 1;
        for(int i = 0;i < lenarr;i ++)          //遍历列，找到元素则返回true
            if(matrix[targetcol][i] == target) return true;
        return false;
    }
}
