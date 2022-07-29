package simpleDifficulty;

import dataStructure.TreeNode;

public class toOffer68I {
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > q.val)
            return dfs(root.left, p, q);
        if(root.val < p.val)
            return dfs(root.right, p, q);
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = p;
        if(p.val > q.val){
            p = q;
            q = temp;
        }

        return dfs(root, p, q);
    }
}
