package middle;

import dataStructure.ListNode;

public class p24 {
    public static void main(String[] args) {
        p24 t = new p24();
        ListNode l = new ListNode(0);
        ListNode head = l;      //注意这里不能为了底下使用方便直接head = l.next,这样赋给的是一个指针，head最终会指向链表末尾
        for(int i = 1;i < 1;i ++){
            ListNode l2 = new ListNode(i);
            l.next = l2;
            l = l.next;
        }
        ListNode list = t.swapPairs(head.next);
        while(list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = new ListNode();
        newhead.next = head;
        ListNode slow = newhead, quick = head.next;
        while (quick != null){
            slow.next.next = quick.next;
            quick.next = slow.next;
            slow.next = quick;
            slow = quick.next;
            if(slow.next != null){
                quick = slow.next.next;
            }else{
                break;
            }
        }
        return newhead.next;
    }
}

