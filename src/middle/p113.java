package middle;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class p113 {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        p113 t = new p113();
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

        System.out.println(t.pathSum(root, 104));
    }
    public void recursionTree(TreeNode root, List<Integer> list, int nowSum, int sum){
        if(root.left == null && root.right == null && nowSum == sum){
//            System.out.println(nowSum + root.val);
            res.add(new ArrayList<>(list));
        }
        if(root.right != null) {
            list.add(root.right.val);
            recursionTree(root.right, list, nowSum + root.right.val, sum);
            list.remove(list.size() - 1);
        }
        if(root.left != null) {
            list.add(root.left.val);
            recursionTree(root.left, list,nowSum + root.left.val, sum);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        recursionTree(root, list, root.val, sum);
        return res;
    }
}
