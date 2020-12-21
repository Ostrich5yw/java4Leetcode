package simple;

import dataStructure.TreeNode;

public class p110 {
    boolean N = true;
    public static void main(String[] args) {
        p110 t = new p110();
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

        System.out.println(t.isBalanced(root));
    }
    public int recursionTree(TreeNode root){
        if(root == null) return 0;
        int right = recursionTree(root.right) + 1;
        int left = recursionTree(root.left) + 1;
        if(Math.abs(right - left) > 1) N = false;
        return right > left ? right : left;
    }
    public boolean isBalanced(TreeNode root) {
        recursionTree(root);
        return N;
    }
}
