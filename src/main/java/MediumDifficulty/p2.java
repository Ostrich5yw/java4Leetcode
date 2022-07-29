package MediumDifficulty;

import dataStructure.ListNode;

/**
 * @author 5yw
 * @date 2022/2/23 9:44
 */
public class p2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mark = 0, nowPos = 0;
        ListNode res = new ListNode();
        ListNode head = res;
        while(l1!=null||l2!=null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            nowPos = n1 + n2 + mark;
            mark = nowPos / 10;
            nowPos = nowPos % 10;
            res.next = new ListNode(nowPos, null);
            res = res.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l1 != null){
                l2 = l2.next;
            }
        }
        if(mark == 1){
            res.next = new ListNode(1, null);
        }
        return head.next;
    }
}
