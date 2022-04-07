package middle;

import dataStructure.ListNode;

public class p147 {
    //    public static void main(String[] args) {
//        test tt = new test();
//        ListNode end = new ListNode(1);
//        ListNode list = null;
//        for (int i = 2;i < 10; i ++){
//            list = new ListNode(i, end);
//            end = list;
//        }
//        tt.insertionSortList(list);
//    }
    public ListNode insertionSortList(ListNode head) {
        ListNode newhead = new ListNode();          //引入哑节点，便于在头节点前插入节点
        newhead.next = head;
        ListNode quick = head;                      //quick负责记录当前遍历到的位置，slow负责比较quick应该插入到哪一个位置
        ListNode slow = newhead;
        while(quick.next != null){
            boolean mark = false;                   //如果quick插入到了前面的有序序列中，则说明quick.next被删除并插入前面了，所以不需要再quick=quick.next
            while(slow.next != quick.next){                 //循环比较，找寻插入位置
                if(slow.next.val >= quick.next.val){        //将quick.next取出原位置，并插入到新位置
                    ListNode temp = quick.next;
                    quick.next = quick.next.next;
                    temp.next = slow.next;
                    slow.next = temp;
                    mark = true;
                    break;
                }
                slow = slow.next;
            }
            slow = newhead;                                 //slow重新归位
            if(!mark)                                       //如果quick.next未被删除并插入到前面，则往后走一个
                quick = quick.next;
        }
//        ListNode ll = newhead;
//        while(ll != null)
//        {
//            System.out.print(ll.val);
//
//            ll = ll.next;
//        }
//        System.out.println("................");
        return newhead.next;
    }
}
