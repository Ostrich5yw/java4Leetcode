package simple;


import dataStructure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class p104 {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        p104 t = new p104();
        /**
         *      32
         *    26  47
         *  19       56
         *    27    21
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
        System.out.println(t.maxDepth(root));
    }
    public int recursionDepth(TreeNode root, int depth){
        if(root == null) return depth - 1;
        int left = recursionDepth(root.left, depth + 1);
        int right = recursionDepth(root.right, depth + 1);
        return Math.max(left, right);
    }
    public int maxDepth(TreeNode root) {
        int depth = 1;
        return recursionDepth(root, depth);
    }
}
