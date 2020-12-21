import dataStructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        test t = new test();
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
            recursionTree(root, res);
            TreeNode tt = root;
            tt.left = null;
            for (int i = 0; i < res.size(); i++) {
                tt.right = res.get(i);
                tt.right.left = null;
                tt = tt.right;
            }
        }

    }
}