package middle;

import dataStructure.ListNode;

public class p148 {
    public ListNode Merge(ListNode slow, ListNode quick){           //合并已排序的两个链表
        ListNode head = new ListNode();
        ListNode mark = head;
        while(slow != null || quick != null){
            if(slow == null){ head.next = quick;break;}
            if(quick == null){ head.next = slow;break;}
            if(slow.val < quick.val){
                head.next = slow;
                slow = slow.next;
            } else {
                head.next = quick;
                quick = quick.next;
            }
            head = head.next;
        }
        return mark;
    }
    public ListNode sortList(ListNode head) {
        if(head.next == null || head == null)          //递归终止条件，即链表仅剩一个元素时，不再递归；同时，也负责处理输入为null的情况
            return head;
        ListNode newhead = new ListNode();          //引入哑节点，便于在头节点前插入节点
        newhead.next = head;
        ListNode slow = newhead;
        ListNode quick = slow;
        while(quick.next != null && quick.next.next != null){       //快慢指针，负责将数组分割为等长的两部分
            slow = slow.next;
            quick = quick.next.next;
        }
        quick = slow.next;                  //slow记录前半部分起始节点   quick记录后半部分起始节点
        slow.next = null;                   //前后两部分要分割为不同的两个链表
        slow = newhead.next;

        ListNode t1 = sortList(slow);               //递归进行归并排序
        ListNode t2 = sortList(quick);
        ListNode t3 = Merge(t1, t2).next;
//        ListNode ll = t3;
//        while(ll != null)
//        {
//            System.out.print(ll.val);
//
//            ll = ll.next;
//        }
//        System.out.println("................");

        return t3;
    }

}
