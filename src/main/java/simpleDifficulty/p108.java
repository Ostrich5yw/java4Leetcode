package simpleDifficulty;


import dataStructure.TreeNode;

import java.util.*;

public class p108 {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        p108 t = new p108();
        System.out.println(t.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
    public TreeNode recursionTree(int[] nums, int nowS, int nowE){
        if(nowS > nowE) return null;                        //左限超过右限，说明是叶节点的子节点
        if(nowS == nowE) return new TreeNode(nums[nowS]);   //左右限相等，说明是叶节点
//        System.out.println(nowS + " " + nowE);
        int middle = (nowE + nowS) / 2;                     //取中间节点，将nowS与nowE包围的数组分为左子树和右子树
        TreeNode root = new TreeNode(nums[middle]);
        root.left = recursionTree(nums, nowS, middle - 1);
        root.right = recursionTree(nums, middle + 1, nowE);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursionTree(nums, 0, nums.length - 1);
    }
}
