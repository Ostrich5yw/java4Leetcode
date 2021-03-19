package oldProblem;

import dataStructure.TreeNode;

public class p98 {
    long pre = Long.MIN_VALUE;
    public static void main(String[] args) {
        p98 t = new p98();
        TreeNode bottom2 = new TreeNode(56, null, null);
        TreeNode right = new TreeNode(47, null, bottom2);
        TreeNode bottom4 = new TreeNode(27, null ,null);
        TreeNode bottom3 = new TreeNode(19, null ,bottom4);
        TreeNode left = new TreeNode(26, bottom3, null);
        TreeNode root = new TreeNode(32 , left, right);
        System.out.println(t.isValidBST(root));
    }
    public boolean SubTree(TreeNode node) {
        if(node == null) return true;
        if(!SubTree(node.left)) return false;
        if(node.val <= pre) return false;
        pre = node.val;
        return SubTree(node.right);
    }
    public boolean isValidBST(TreeNode root) {
        return SubTree(root);
    }
}