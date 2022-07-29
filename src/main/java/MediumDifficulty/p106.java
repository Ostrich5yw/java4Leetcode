package MediumDifficulty;


import dataStructure.TreeNode;

import java.util.*;

public class p106 {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        p106 t = new p106();
        /**
         *      3
         *    9  20
         *     15  7
         * **/
        System.out.println(t.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
    public TreeNode recursionTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe){
        if(ps > pe || is > ie) return null;
        int middlePos = map.get(postorder[pe]);
//        System.out.println(middlePos);
        TreeNode middleNode = new TreeNode(inorder[middlePos]);
        middleNode.left = recursionTree(inorder, postorder, is, middlePos - 1, ps, ps + middlePos - is  - 1);
        middleNode.right = recursionTree(inorder, postorder, middlePos + 1, ie, ps + middlePos - is, pe - 1);
        return middleNode;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length;i ++){
            map.put(inorder[i], i);
        }
        return recursionTree(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }
}
