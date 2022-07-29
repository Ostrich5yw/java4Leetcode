package simpleDifficulty;

import dataStructure.TreeNode;

public class p111 {
    public static void main(String[] args) {
        p111 t = new p111();
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

        System.out.println(t.minDepth(root));
    }
    public int recursionTree(TreeNode root){
        if(root.right == null && root.left == null) return 1;           //只有到达叶节点时才可以开始记录深度
        int right = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        //只存在左或右单子节点的节点，这些节点不为空的那一边设为MAX，不再考虑其对结果的影响
        if(root.right != null) right = recursionTree(root.right) + 1;
        if(root.left != null) left = recursionTree(root.left) + 1;
        return right < left ? right : left;
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return recursionTree(root);
    }
}
