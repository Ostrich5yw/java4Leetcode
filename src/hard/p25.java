package hard;

import dataStructure.ListNode;

/**
 * @author 5yw
 * @date 2022/3/18 10:15
 */
public class p25 {
    public ListNode swapList(ListNode head, ListNode tail) {        //  1,2,3,4,5，null  head指向1，tail指向null
        ListNode temp = tail;
        ListNode cur = head, rec = head.next;
        while(cur != tail){
            cur.next = temp;
            temp = cur;
            if(rec == null)     //当k==len(list) 需要提前结束
                break;
            cur = rec;
            rec = rec.next;
        }
        return temp;        //返回新头结点5
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newhead = new ListNode();
        newhead.next = head;
        ListNode slow = newhead, quick = newhead;
        for(int i = 0;i < k;i ++)
            if(quick == null)
                break;
            else
                quick = quick.next;     //slow 指向待翻转序列的前一个节点，quick指向待翻转序列的尾结点
        while (quick != null){
            ListNode tail = slow.next;      // 记录待翻转序列的头结点，反转后会是尾结点，quick将在反转后指向它
            slow.next = swapList(slow.next, quick.next);
            quick = tail;
            for(int i = 0;i < k;i ++)   // slow quick同时后移k位
                if(quick == null)
                    break;
                else {
                    quick = quick.next;
                    slow = slow.next;
                }
        }
        return newhead.next;
    }
}
