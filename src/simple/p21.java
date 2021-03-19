package simple;

import dataStructure.ListNode;

public class p21 {
    public static void main(String[] args) {
        p21 t = new p21();
        ListNode list1 = new ListNode(0);
        ListNode head1 = list1;
        for(int i = 1;i < 5;i ++){
            ListNode list2 = new ListNode(i);
            list1.next = list2;
            list1 = list1.next;
        }

        ListNode list3 = new ListNode(0);
        ListNode head2 = list3;
        for(int i = 2;i < 5;i ++){
            ListNode list4 = new ListNode(i);
            list3.next = list4;
            list3 = list3.next;
        }
        ListNode l = t.mergeTwoLists(head1.next, head2.next);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listnode = new ListNode();
        ListNode head = listnode;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ListNode temp = new ListNode(l1.val);
                listnode.next = temp;
                l1 = l1.next;
            }else{
                ListNode temp = new ListNode(l2.val);
                listnode.next = temp;
                l2 = l2.next;
            }
            listnode = listnode.next;
        }
        while(l1 != null){
            ListNode temp = new ListNode(l1.val);
            listnode.next = temp;
            listnode = listnode.next;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode temp = new ListNode(l2.val);
            listnode.next = temp;
            listnode = listnode.next;
            l2 = l2.next;
        }
        return head.next;
    }
}

