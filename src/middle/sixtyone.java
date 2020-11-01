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
        int len = 1;
        int firstPos;
        int cutPos;
        while(pointer.next != null){
            len ++;
            pointer = pointer.next;
        }
        ListNode end = pointer;
        firstPos = 0 + k;
        while(firstPos > len - 1)       //找到旋转过后，原先数组首元素当前的位置(firstPos)
            firstPos -= len;
        if(firstPos == 0)
            return head;

        cutPos = len - firstPos;        // cutPos记录数组从哪里断开，即它之后的元素，与之前的元素整体交换位置(1,2,3,4,5) cutPos=2  (4,5,1,2,3)

        pointer = head;
        while (cutPos > 1){             // 找到这个位置对应的链表节点，保存为pointer
            pointer = pointer.next;
            cutPos --;
        }                                           //结束后，pointer目前指向移动完毕后的最后一个元素
//        while(firstPos > 1){
//            newFirst = newFirst.next;
//            firstPos --;
//        }
        end.next = head;                    //末尾元素指向原头结点，完成新链
        ListNode newFirst = pointer.next;   //pointer之后的节点成为新的头结点
        pointer.next = null;
//        while(newFirst != null)
//        {
//            System.out.println(newFirst.val);
//            newFirst = newFirst.next;
//        }
        return newFirst;
    }

}

