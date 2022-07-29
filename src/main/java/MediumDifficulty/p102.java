package MediumDifficulty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import dataStructure.TreeNode;


public class p102 {
    long pre = Long.MIN_VALUE;
    public static void main(String[] args) {
        p102 t = new p102();
        /**
         *      32
         *    26  47
         *  19       56
         *    27
         * **/
        TreeNode bottom2 = new TreeNode(56, null, null);
        TreeNode right = new TreeNode(47, null, bottom2);
        TreeNode bottom4 = new TreeNode(27, null ,null);
        TreeNode bottom3 = new TreeNode(19, null ,bottom4);
        TreeNode left = new TreeNode(26, bottom3, null);
        TreeNode root = new TreeNode(32 , left, right);
        System.out.println(t.levelOrder(root));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        int levelNum = 1;           //levelNum记录当前正在遍历的行的个数，nextNum记录他们生成的下一行节点的个数
        int nextNum = 0;
        list.addLast(root);
        while(!list.isEmpty()){         //当list不为空，即下一行还有值(levelNum > 0)
            List<Integer> tempres = new ArrayList<>();
            while(levelNum != 0){               //记录当前遍历行拥有的节点个数，本题中，依次为1，2，2，1
                TreeNode temp = list.pop();      //取队头元素
                levelNum -= 1;                        //遍历节点数-1，减到0说明该行已经遍历完毕
                if(temp.left != null) {list.addLast(temp.left); nextNum ++;}    //将他的非空左右节点加入队列，nextNum用来记录下一行拥有的节点数
                if(temp.right != null) {list.addLast(temp.right); nextNum ++;}
                tempres.add(temp.val);          //该节点值加入结果集
            }
            res.add(tempres);                   //结果集记录每一行的节点值，将每一行结果集加入最终的返回集
            levelNum = nextNum;     //进入下一行，levelNum取下一行的节点数，nextNum重新置0
            nextNum = 0;
        }
        return res;
    }
}
