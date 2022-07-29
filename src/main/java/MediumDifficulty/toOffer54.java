package MediumDifficulty;

import dataStructure.TreeNode;

public class toOffer54 {
    int rec;
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int a = dfs(root.right);
        if(--rec == 0){
            return root.val;
        }
        int b = dfs(root.left);
        return Math.max(a, b);
    }
    public int kthLargest(TreeNode root, int k) {
        rec = k;
        return dfs(root);
    }
}
