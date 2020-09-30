import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class test {
    public static void main(String[] args) {
        test t = new test();
        ListNode l = new ListNode(0);
        ListNode head = l;      //注意这里不能为了底下使用方便直接head = l.next,这样赋给的是一个指针，head最终会指向链表末尾
        for(int i = 1;i < 5;i ++){
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
        ListNode list = head;
        ListNode headlist = list;
        while(list.next != null){
            ListNode temp1 = new ListNode(list.val); temp1.next = list.next.next;
            ListNode temp2 = new ListNode(list.next.val); temp2.next = list.next;
            System.out.println(temp1.val+ " " + temp2.val + " ");
            list = temp2;
            list.next = temp1;
            if(temp1.next != null)
                list = temp1.next;
            else
                list = temp1;
            System.out.println(list.val);
        }
        return head;
    }
}
