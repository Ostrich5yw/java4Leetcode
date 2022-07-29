package MediumDifficulty;

import dataStructure.TreeNode;

public class toOffer36 {
    TreeNode head = new TreeNode();
    TreeNode recHead = head;
    public void dfs(TreeNode root){
        if(root.left != null)
            dfs(root.left);
        head.right = root;
        root.left = head;
        head = head.right;
        if(root.right != null)
            dfs(root.right);
    }
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }
        dfs(root);
        head.right = recHead.right;
        recHead.right.left = head;
        return recHead.right;
    }
}
