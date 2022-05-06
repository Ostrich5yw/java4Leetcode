package MediumDifficulty;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class p129 {
    List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        p129 t = new p129();
        /**
         *      1
         *    2  3
         * **/

        TreeNode right = new TreeNode(3, null, null);
        TreeNode left = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1 , left, right);
        System.out.println(t.sumNumbers(root));
    }
    public void recursionTree(TreeNode root, List<Integer> templist){
        if(root.left == null && root.right == null){
            list.add(new ArrayList<>(templist));
        }
        if(root.left != null) {
            templist.add(root.left.val);
            recursionTree(root.left, templist);
            templist.remove(templist.size() - 1);
        }
        if(root.right != null) {
            templist.add(root.right.val);
            recursionTree(root.right, templist);
            templist.remove(templist.size() - 1);
        }
    }
    public int sumNumbers(TreeNode root) {
        int res = 0;

        recursionTree(root, new ArrayList<Integer>(){{add(root.val);}});    //先序遍历找到所有可能串
        System.out.println(list);
        for(int i = 0;i < list.size();i ++){
            List<Integer> temp = list.get(i);
            int mark = 1;
            for(int j = temp.size() - 1;j >= 0;j --){       //将这些串依次相加，每一个串每一位依次加入结果集res中
                res += temp.get(j) * mark;                  //mark负责记录当前是哪一位，我们从后至前遍历串，mark分别取1，10，100
                mark *= 10;
            }
        }
        return res;
    }
}
