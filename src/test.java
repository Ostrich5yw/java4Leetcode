
import dataStructure.TreeNode;

import java.util.*;

public class test {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        test t = new test();
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
        System.out.println(t.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
    public TreeNode recursionTree(int[] inorder, int[] postorder){

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return;
    }
}