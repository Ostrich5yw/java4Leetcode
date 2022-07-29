package hardDifficulty;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 5yw
 * @date 2021/11/27 14:56
 */
public class p297 {
    public class Codec {
        public String makeString(TreeNode root){
            if(root == null){
                return "n";
            }
            String left = "," + serialize(root.left);
            String right = "," + serialize(root.right);
            return root.val + left + right;
        }
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String res = makeString(root);
            return res;
        }

        public TreeNode makeTree(ArrayList<String> datas, TreeNode root){
            String nowC = datas.get(0);
            datas.remove(0);
            if(!nowC.equals("n")){
                root = new TreeNode(Integer.parseInt(nowC));
                root.left = makeTree(datas, root.left);
                root.right = makeTree(datas, root.right);
            }else{
                root = null;
            }
            return root;
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            ArrayList<String> datas = new ArrayList<>(Arrays.asList(data.split(",")));
            if(datas.get(0).equals("n")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(datas.get(0)));
            datas.remove(0);
            root.left = makeTree(datas, root.left);
            root.right = makeTree(datas, root.right);
            return root;
        }
    }
}
