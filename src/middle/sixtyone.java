package middle;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class sixtyone {
    // Definition for singly-linked list.
    public static void main(String[] args) {
        sixtyone t = new sixtyone();
        ListNode list = new ListNode(1);
        ListNode head = list;
        for(int i = 2;i <= 5;i ++){
            ListNode temp = new ListNode(i);
            list.next = temp;
            list = temp;
        }
//        System.out.println(head.val);
        System.out.println(t.rotateRight(head,  1));
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode pointer = head;
        /**
         *
         * 链表1—>2->3->4->5      位置记为1，2，3，4，5
         *
         * **/
        int len = 1,cut = 1,pos = 1;        //len记录链表长度，cut记录从哪里切断链表，pos负责从head开始，找到cut指向的元素
        while(pointer.next != null){        //得到数组长度，顺便得到链表尾端元素
            len ++;
            pointer = pointer.next;
        }
        cut = len - k % len;            //计算切断位置
        pointer.next = head;            //连接为一个循环链表
        pointer = head;                     //pointer再次开始从头遍历，找到切断的位置，并将切断位置的next记为null，循环链表重新变为链表
        while(pos < cut){
            pos ++;
            pointer = pointer.next;
        }
        head = pointer.next;            //新链表的头指针，就是切断位置的下一个元素
        pointer.next = null;


        pointer = head;          //查看运行后的新head
        while(pointer != null){
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
        return head;
    }
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head == null || head.next == null)
//            return head;
//        ListNode pointer = head;
//        int len = 1;
//        int firstPos;
//        int cutPos;
//        while(pointer.next != null){
//            len ++;
//            pointer = pointer.next;
//        }
//        ListNode end = pointer;
//        firstPos = 0 + k;
//        while(firstPos > len - 1)       //找到旋转过后，原先数组首元素当前的位置(firstPos)
//            firstPos -= len;
//        if(firstPos == 0)
//            return head;
//
//        cutPos = len - firstPos;        // cutPos记录数组从哪里断开，即它之后的元素，与之前的元素整体交换位置(1,2,3,4,5) cutPos=2  (4,5,1,2,3)
//
//        pointer = head;
//        while (cutPos > 1){             // 找到这个位置对应的链表节点，保存为pointer
//            pointer = pointer.next;
//            cutPos --;
//        }                                           //结束后，pointer目前指向移动完毕后的最后一个元素
////        while(firstPos > 1){
////            newFirst = newFirst.next;
////            firstPos --;
////        }
//        end.next = head;                    //末尾元素指向原头结点，完成新链
//        ListNode newFirst = pointer.next;   //pointer之后的节点成为新的头结点
//        pointer.next = null;
////        while(newFirst != null)
////        {
////            System.out.println(newFirst.val);
////            newFirst = newFirst.next;
////        }
//        return newFirst;
//    }

}

