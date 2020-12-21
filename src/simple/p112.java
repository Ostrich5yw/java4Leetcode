package simple;

import dataStructure.TreeNode;
import middle.p102;

public class p112 {
    public static void main(String[] args) {
        p112 t = new p112();
        /**
         *      32
         *    26  47
         *  19      56
         *    27     21
         *         20
         * **/
        TreeNode bottom0 = new TreeNode(20, null, null);
        TreeNode bottom1 = new TreeNode(21, bottom0, null);
        TreeNode bottom2 = new TreeNode(56, bottom1, null);
        TreeNode right = new TreeNode(47, null, bottom2);
        TreeNode bottom4 = new TreeNode(27, null ,null);
        TreeNode bottom3 = new TreeNode(19, null ,bottom4);
        TreeNode left = new TreeNode(26, bottom3, null);
        TreeNode root = new TreeNode(32 , left, right);

        System.out.println(t.hasPathSum(root, 104));
    }
    public boolean recursionTree(TreeNode root, int nowSum, int sum){
        if(root.left == null && root.right == null){
//            System.out.println(nowSum + root.val);
            return nowSum + root.val == sum ? true : false;     //这里返回的是nowSum + root.val，因为nowSum记录的是上一层到根节点的和
        }
        boolean right = false, left = false;
        if(root.right != null) right = recursionTree(root.right, nowSum + root.val, sum);
        if(root.left != null) left = recursionTree(root.left, nowSum + root.val, sum);
        if(right == true || left == true)
            return true;
        else
            return false;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return recursionTree(root, 0 ,sum);
    }
}
