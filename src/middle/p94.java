package middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import dataStructure.TreeNode;


public class p94 {
    public static void main(String[] args) {
        p94 t = new p94();
        TreeNode bottom2 = new TreeNode(5, null, null);
        TreeNode right = new TreeNode(2, bottom2, null);
        TreeNode bottom3 = new TreeNode(4, null ,null);
        TreeNode left = new TreeNode(3, bottom3, null);
        TreeNode root = new TreeNode(1 , left, right);
        /**
         *            1
         *        3      2
         *      4      5
         *      先走到最左端，再依次进入每一节点的右子树
         * **/
        System.out.println(t.inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack stack = new Stack();
        List<Integer> list = new ArrayList<>();
        int mark = 0;                           //mark 记录点的左子树是否已经遍历
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode nowPos = (TreeNode)stack.peek();
            if(nowPos.left != null && mark == 0)        //首先向左遍历到最底部的左子树
                stack.push(nowPos.left);
            else{
                TreeNode temp = (TreeNode)stack.pop();      //元素4弹出，并将mark标记为1
                mark = 1;
                list.add(temp.val);
                if(temp.right != null) {                    //由于4不含右子树，所以不再进入4的右子树
                    mark = 0;                               //下一轮会直接进入3
                    stack.push(temp.right);
                }
            }
        }
        return list;
    }
}
