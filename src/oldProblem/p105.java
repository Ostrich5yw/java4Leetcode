package oldProblem;

import dataStructure.TreeNode;

import java.util.*;

public class p105 {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        p105 t = new p105();
        /**
         *      3
         *    9  20
         *      15 7
         * **/
        System.out.println(t.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
    /**
     * 先序数组的首节点是根节点，再找到根节点在中序数组中的位置，将中序数组一分为二，前半部分是左子树的中序数组，后半部分是右子树的中序数组
     * 再根据中序数组前后两部分 分别的元素数量，就可以推出左子树的先序数组，右子树的先序数组
     * **/
    //四个参数分别表示当前子树的先序遍历数组在原数组中的范围，中序遍历数组在原数组中的范围
    public TreeNode recursionbuild(int[] preorder, int[] inorder, int pres, int pree, int ins, int ine){
        if( pres > pree || ins > ine) return null;        //如果上下限范围超出或者先序的下限超过数组长度，说明它的左/右子树不存在，返回null
        TreeNode root = new TreeNode(preorder[pres]); //如果存在，则先序的第一个元素就是当前子树的根节点
        int nowroot = map.get(preorder[pres]);      //找到根节点在中序数组中的位置
        int left = nowroot - ins;             //left记录左子树的节点数量
        //假如中序数组是1，2，3，4   根节点是3，则左子树有2个节点，从0-1，右子树有1个节点，从3-3
        /**
         * 所以左子树的先序遍历数组范围是pres + 1到 pres + left，中序遍历的范围是ins到 nowroot - 1
         *     右子树的先序遍历数组范围是pres + left + 1到 pree，中序遍历的范围是nowroot + 1到 ine
         * **/
        root.left = recursionbuild(preorder, inorder, pres + 1, pres + left, ins, nowroot - 1);
        root.right = recursionbuild(preorder, inorder, pres + left + 1, pree, nowroot + 1, ine);
        return root;        //返回当前子树的根节点
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i ++){
            map.put(inorder[i], i);             //因为我们要根据先序遍历的首节点寻找它在中序数组中的位置，所以生成中序的(值，位置)哈希表便于查找
        }
        return recursionbuild(preorder, inorder, 0, preorder.length, 0 ,inorder.length);
    }

}
