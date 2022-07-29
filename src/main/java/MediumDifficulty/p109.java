package MediumDifficulty;


import dataStructure.ListNode;
import dataStructure.TreeNode;
import java.util.*;

public class p109 {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        p109 t = new p109();

        ListNode list5 = new ListNode(9, null);
        ListNode list1 = new ListNode(5, list5);
        ListNode list2 = new ListNode(0, list1);
        ListNode list3 = new ListNode(-3, list2);
        ListNode list = new ListNode(-10, list3);
        System.out.println(t.sortedListToBST(list));
    }
    public TreeNode recursionTree(ListNode start, ListNode end){
        if(start == end) return null;       //start == end说明是叶子节点的子节点
        ListNode fast = start, slow = start;
        while(fast.next != end && fast.next.next != end){       //快慢指针，快指针走两步，慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);     //慢指针所指就是中间节点
        root.left = recursionTree(start, slow);         //将其一分为二
        root.right = recursionTree(slow.next, end);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return recursionTree(head, null);           //这是一个左闭右开的集合，其中右子树的第二个系数始终为null
    }
}
