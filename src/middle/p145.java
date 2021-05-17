package middle;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p145 {         //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode p = root, r = null;
        ArrayList<Integer> res = new ArrayList<>();
        while(!list.isEmpty() || p != null){
            if(p != null){
                list.push(p);
                p = p.left;
            } else {
                p = list.peek();
                if(p.right == null || p.right == r) {
                    res.add(p.val);
                    list.pop();
                    r = p;
                    p = null;
                } else {
                    p = p.right;
                }
            }
        }
        return res;
    }
}
