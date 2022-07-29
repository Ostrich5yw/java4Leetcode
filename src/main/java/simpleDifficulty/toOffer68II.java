package simpleDifficulty;

import dataStructure.TreeNode;

public class toOffer68II {
    boolean mark = true;
    TreeNode res;
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if(((left && right) || ((root == p || root == q) && (left || right))) && mark == true){
            mark = false;
            res = root;
            return true;
        }
        if(root == p || root == q || left || right){
            return true;
        }
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
}
