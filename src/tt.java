import dataStructure.Node;

import java.util.Arrays;
import java.util.Comparator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class tt {
    public static void main(String[] args){
        tt t = new tt();
        Node three1 = new Node(4, null, null, null);
        Node three2 = new Node(5, null, null, null);
        Node two2 = new Node(3, null, null, null);
        Node two1 = new Node(2, three1, three2, null);
        Node root = new Node(1, two1, two2, null);
        System.out.println(t.connect(root));
    }
    public void recursionNode(Node root){
        if(root.left != null)                           //由于是完全二叉树，所以我们只需要让其左子树的next指向右子树
            root.left.next = root.right;
        if(root.next != null && root.right != null)     //右子树的next指向root.next的左子树
            root.right.next = root.next.left;
        if(root.left != null)
            recursionNode(root.left);
        if(root.right != null)
            recursionNode(root.right);
    }
    public Node connect(Node root) {
        if(root == null) return null;
        recursionNode(root);
        return root;
    }
//    public Node connect(Node root) {
//        if(root == null) return null;
//        LinkedList<Node> father = new LinkedList<>();
//        father.add(root);
//        while(!father.isEmpty()){
////            for(int i = 0;i < father.size() - 1;i ++){
////                father.get(i).next = father.get(i + 1);
////            }
//            LinkedList<Node> son = new LinkedList<>();
//            Node pre = new Node();
//            while(!father.isEmpty()) {
//                Node temp = father.removeFirst();
//                if (temp.left != null) {
//                    pre.next = temp.left;
//                    son.add(temp.left);
//                    pre = temp.left;
//                }
//                if (temp.right != null) {
//                    pre.next = temp.right;
//                    son.add(temp.right);
//                    pre = temp.right;
//                }
//            }
//            father = son;
//        }
//        return root;
//    }
}
