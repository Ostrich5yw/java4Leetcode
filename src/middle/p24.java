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
        if (head == null || head.next == null)
            return head;
        ListNode list = head;
        head = head.next;
        while(list.next != null){
            ListNode temp1 = new ListNode(list.val); temp1.next = list.next.next;               //temp1作为一个新节点，存放原奇数位的val，并且指向下一原奇数位
            list.next.next = temp1;                                                             //原偶数位指向新节点temp1，
//            System.out.println(temp1.val+ " " + list.next.next.val + " " + list.next.next.next.val);
            if(temp1.next != null) {
                if(temp1.next.next == null)         //若有奇数个成员(temp1.next即是最后一个奇数位的成员，它的next为null)，直接返回head
                    return head;
                list = temp1.next;           //还未到最后一位，则list指向temp1下一个位(暂存，事实上temp1最终代替了这些奇数位成为链表一份子),temp1的下一位指向下一偶数项
                temp1.next = temp1.next.next;
            }
            else{                                   //正好有偶数个成员(temp1刚好就是最后一个偶数位的成员，它的next为null)，直接返回head
                return head;
            }
        }
        return head;
    }
}
