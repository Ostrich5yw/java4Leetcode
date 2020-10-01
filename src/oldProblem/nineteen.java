package oldProblem;

import java.util.List;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//public class test {
//    public static void main(String[] args) {
//        test t = new test();
//        ListNode ln = new ListNode(1);
//        ListNode first = ln;
//        for(int i = 2;i <= 5;i ++){             //遍历生成一个1，2，3，4，5的链
//            ln.next = new ListNode(i);
//            ln = ln.next;
//        }
//        first = t.removeNthFromEnd(first,5);    //删除倒数第n个值
//        while(first != null) {
//            System.out.println(first.val);
//            first = first.next;
//        }
//    }
//
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int temp,rec = 0;
//        ListNode newhead = new ListNode(0);     //建立一个头结点，在删除首节点时，方便操作
//        newhead.next = head;
//        head = newhead;
//        while(newhead.next != null){               //遍历得到链表长度
//            newhead = newhead.next;
//            rec ++;
//        }
//        temp = rec - n + 1;                         //倒数转正数，temp指示正数第几位
//        newhead = head;
//        while(--temp > 0)                           //找到temp前一节点
//            newhead = newhead.next;
//        newhead.next = newhead.next.next;           //删除temp节点，并返回保存着首结点的head.next
//        return head.next;
//    }
//}

//方法二：快慢指针
import java.util.List;

class ListNode19 {
    int val;
    ListNode19 next;
    ListNode19(int x) { val = x; }
}
public class nineteen {
    public static void main(String[] args) {
        nineteen t = new nineteen();
        ListNode19 ln = new ListNode19(1);
        ListNode19 first = ln;
        for(int i = 2;i <= 5;i ++){             //遍历生成一个1，2，3，4，5的链
            ln.next = new ListNode19(i);
            ln = ln.next;
        }
        first = t.removeNthFromEnd(first,1);    //删除倒数第n个值
        while(first != null) {
            System.out.println(first.val);
            first = first.next;
        }
    }

    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        ListNode19 slow = new ListNode19(0);     //建立一个头结点，在删除首节点时，方便操作
        slow.next = head;
        head = slow;
        ListNode19 fast = slow;
        while(n-- != 0){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head.next;
    }
}


