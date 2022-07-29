package MediumDifficulty;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class toOffer35 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        Node recHead = head;
        Node temp = newHead;
        while(head != null){
            Node newNode = new Node(head.val);
            temp.next = newNode;
            map.put(head, newNode);
            temp = newNode;
            head = head.next;
        }
        head = recHead;
        temp = newHead.next;
        while(head != null){
            temp.random = map.get(head.random);
            head = head.next;
            temp = temp.next;
        }
        return newHead.next;
    }
}
