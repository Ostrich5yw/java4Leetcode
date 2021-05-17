package middle;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p144 {   //先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode p = root, r = null;
        ArrayList<Integer> res = new ArrayList<>();
        while(!list.isEmpty() || p != null){
            while(p != null){
                res.add(p.val);
                list.push(p);
                p = p.left;
            }
            p = list.pop();
            p = p.right;
        }
        return res;
    }

    // 中序遍历
//    TreeNode p = head;
//    ArrayList<Integer> res = new ArrayList<>();
//    LinkedList<TreeNode> list = new LinkedList<>();
//	  while (!list.isEmpty() || p != null) {
//        while (p != null) {
//            list.push(p);
//            p = p.left;
//        }
//        p = list.pop();
//        res.add(p.val);
//        p = p.right;
//    }
}
