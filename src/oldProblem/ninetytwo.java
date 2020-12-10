package oldProblem;

class ListNode92 {
    int val;
    ListNode92 next;
    ListNode92(int x) { val = x; }
}
/**
 * 依靠递归回溯实现指针旋转
 * **/
public class ninetytwo {
    ListNode92 left,right;
    public static void main(String[] args) {
        ninetytwo t = new ninetytwo();
        ListNode92 head = new ListNode92(1);
        ListNode92 list = head;
        for(int i = 2;i <= 5;i ++){
            ListNode92 temp = new ListNode92(i);
            list.next = temp;
            list = temp;
        }
        System.out.println(t.reverseBetween(head, 1, 4));    //1.2.3.4.5
    }
    public int reverse(ListNode92 nowPos, int arrPos, int n){     //arrPos记录当前索引号(1开始)，n记录目标索引号(旋转终止位置)
        if(arrPos == n) {                   //arrPos搜索到指定位置后，开始回溯
            right = nowPos;                 //right指向旋转终止位置
            return 1;
        }
        if(reverse(nowPos.next, arrPos + 1, n) == 1){       //如果回溯为1
//            System.out.println(right.val + " " + left.val);
            if(right.next == left || right == left)                 //如果right走到left之前或left，right指向一处，说明已经旋转完毕，return 0。
                return 0;                                           //后续回溯不再进行left，right交换
            int temp = right.val;                                   //交换left，right的值(分别记录还未旋转部分的头，尾节点)
            right.val = left.val;
            left.val = temp;
            left = left.next;
            right = nowPos;
        }
        return 1;
    }
    public ListNode92 reverseBetween(ListNode92 head, int m, int n) {
        ListNode92 newhead = head;
        int tt = 1;                         // tt记录现在遍历位置的索引号(从1开始)
        while(newhead != null) {
            if (tt == m) {                  // 找到开始的位置
                left = newhead;             //left记录旋转开始位置
                reverse(newhead, tt, n);    //开始递归
                break;
            }
            tt ++;
            newhead = newhead.next;
        }
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        return head;
    }
}
