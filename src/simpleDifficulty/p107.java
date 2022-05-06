package simpleDifficulty;


import dataStructure.TreeNode;

import java.util.*;

public class p107 {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        p107 t = new p107();
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
        System.out.println(t.levelOrderBottom(root));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        List<List<TreeNode>> nodelist = new ArrayList<>();      //先将所有节点按行存入nodelist，每一行就是一个List<TreeNode>
        List<TreeNode> temp1 = new ArrayList<>();
        temp1.add(root);            //temp1存放该行，temp2存放当前行的子节点
        while(temp1.size() != 0){
            nodelist.add(temp1);
            List<TreeNode> temp2 = new ArrayList<>();
            for(int i = 0;i < temp1.size();i ++) {
                TreeNode treeNode = temp1.get(i);
                if(treeNode.left != null) temp2.add(treeNode.left);
                if(treeNode.right != null) temp2.add(treeNode.right);
            }
            temp1 = new ArrayList<>(temp2);
        }
        for(int i = nodelist.size() - 1;i >= 0;i --){       //从后至前，将nodelist中的数组的值存入list中
            List<TreeNode> temp = nodelist.get(i);
            List<Integer> res = new ArrayList<>();
            for(int j = 0;j < temp.size();j ++){
                res.add(temp.get(j).val);
            }
            list.add(res);
        }
        return list;
    }
}