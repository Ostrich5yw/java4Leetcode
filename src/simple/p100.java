package simple;
import dataStructure.TreeNode;


public class p100 {
    long pre = Long.MIN_VALUE;
    public static void main(String[] args) {
        p100 t = new p100();
        /**
         *      32
         *    26  47
         *  19       56
         *    27
         * **/
        TreeNode bottom1 = new TreeNode(27, null, null);
        TreeNode bottom2 = new TreeNode(19, bottom1, null);
        TreeNode right = new TreeNode(26, null, bottom2);
        TreeNode bottom4 = new TreeNode(27, null ,null);
        TreeNode bottom3 = new TreeNode(19, null ,bottom4);
        TreeNode left = new TreeNode(26, bottom3, null);
        TreeNode root = new TreeNode(32 , left, right);
        System.out.println(t.isSameTree(left, right));
    }
    public boolean recursionCompare(TreeNode left, TreeNode right){
        if(left == null || right == null || left.val != right.val)  //一边有一边为空，或两边值不等，则返回false
            return false;
        boolean a = true, b = true;
        if(left.right != null || right.right != null)           //分别比较两树的左右子节点是否相等
            a = recursionCompare(left.right, right.right);
        if(left.left != null || right.left != null)
            b = recursionCompare(left.left, right.left);
        if(a == false || b == false)        //如果任意一边不相等，则返回false
            return false;
        return true;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        return recursionCompare(p, q);
    }
}
