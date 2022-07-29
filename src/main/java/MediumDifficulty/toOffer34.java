package MediumDifficulty;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class toOffer34 {
    List<List<Integer>> res;
    public int dfs(TreeNode root, List<Integer> list, int target){
        if(root.right == null && root.left == null && target == 0){
            res.add(new ArrayList<Integer>(){{addAll(list);}});
            return 0;
        }
        if(root.right != null){
            list.add(root.right.val);
            dfs(root.right, list, target - root.right.val);
            list.remove(list.size()-1);
        }
        if(root.left != null){
            list.add(root.left.val);
            dfs(root.left, list, target - root.left.val);
            list.remove(list.size()-1);
        }
        return 0;
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root, new ArrayList<Integer>(){{add(root.val);}}, target - root.val);
        return res;
    }
}
