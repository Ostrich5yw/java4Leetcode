package MediumDifficulty;

import dataStructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class p114 {
    public static void main(String[] args) {
        p114 t = new p114();
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
        TreeNode root = new TreeNode(32 , null, null);

        t.flatten(root);
    }
    public void recursionTree(TreeNode root, List<TreeNode> list){
        list.add(root);
        if(root.left != null) recursionTree(root.left, list);
        if(root.right != null) recursionTree(root.right, list);
    }
    public void flatten(TreeNode root) {
        if(root != null && (root.left != null || root.right!= null)) {
            List<TreeNode> res = new ArrayList<>();
            recursionTree(root, res);       //先序遍历二叉树并存入res数组中
            TreeNode tt = root;
            tt.left = null;                 //将其修改为左子树为空的单链表结构
            for (int i = 0; i < res.size(); i++) {
                tt.right = res.get(i);
                tt.right.left = null;
                tt = tt.right;
            }
        }
    }
}
