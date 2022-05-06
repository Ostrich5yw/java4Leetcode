package MediumDifficulty;

import dataStructure.Node;

import java.util.LinkedList;

public class p117 {
    public static void main(String[] args) {
        p117 t = new p117();
        Node three1 = new Node(4, null, null, null);
        Node three2 = new Node(5, null, null, null);
        Node two2 = new Node(3, null, null, null);
        Node two1 = new Node(2, three1, three2, null);
        Node root = new Node(1, two1, two2, null);
        t.connect(root);
    }
    public Node connect(Node root) {
        if(root == null) return null;
        LinkedList<Node> list = new LinkedList<>();
        list.addFirst(root);
        while(!list.isEmpty()){
            int prelen = list.size();                   //只使用一个链表完成层次遍历，这里使用prelen记录当前层的节点数，
            while(prelen-- > 0){                        //我们只处理prelen个节点，之后的即是新加入链表的节点(下一层的节点)
                Node current = list.pollFirst();
                if(prelen > 0)
                    current.next = list.peekFirst();
                else
                    current.next = null;
                if(current.left != null) list.addLast(current.left);
                if(current.right != null) list.addLast(current.right);
            }
        }
        return root;
    }
}
