package oldProblem;

import dataStructure.TreeNode;
import java.util.ArrayList;
import java.util.List;


public class p95 {
    public static void main(String[] args) {
        p95 t = new p95();
        System.out.println(t.generateTrees(3));
    }
    public List<TreeNode> findTree(int left, int right){
        List<TreeNode> allTrees = new ArrayList<>();
        if(left > right){       //当left > right 说明已经到达叶子节点，所以我们把叶子节点的子节点allTrees置为null
            allTrees.add(null);
            return allTrees;
        }
        for(int p = left;p <= right;p ++) {     //由于不是平衡二叉树，所以left，right任何一个值都可以作为当前位置的根节点
            List<TreeNode> leftlist = findTree(left, p - 1);      //递归查找左子树，返回左子树所有可能的子树型，List中存放这些子树的根节点
            List<TreeNode> rightlist = findTree(p + 1, right);     //递归查找右子树
            for(TreeNode templeft : leftlist)         //比如左子树有2种，右子树有2种，则对于当前位置的根节点p来说，一共可以生成4种树
                for(TreeNode tempright : rightlist)
                {
                    TreeNode temp = new TreeNode(p);
                    temp.left = templeft;
                    temp.right = tempright;
                    allTrees.add(temp);             //allTrees存放同样以p为根的多种不同树
                }
        }
        return allTrees;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return (List)new ArrayList<TreeNode>();
        return findTree(1, n);
    }
}