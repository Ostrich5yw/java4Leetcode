package oldProblem;

import dataStructure.ListNode;

public class p86 {
    public static void main(String[] args) {
        p86 t = new p86();
        int[] arr = new int[]{4 ,3, 2, 5, 2};
        ListNode head = new ListNode(1);
        ListNode list = head;
//        for(int i = 0;i < arr.length;i ++){
//            ListNode temp = new ListNode(arr[i]);
//            list.next = temp;
//            list = temp;
//        }
        System.out.println(t.partition(head, 0));
    }
    public ListNode partition(ListNode head, int x) {
        int mark = 0;
        ListNode temphead = new ListNode(100000);           //初始化一个头节点，使得该节点指向head
        temphead.next = head;
        ListNode quick = temphead;
        ListNode slow = temphead;
        ListNode temp;
        ListNode temp2;        //quick，slow，head均移动到temphead处
        head = temphead;
        /**
         * 我们从temphead开始，quick.next进行链表搜索，如果遇到小于x的，则将其记为slow.next记录小于x的首元素，
         * 同时把mark记为1(之后遇到连续的小于x的元素则不会再移动slow),直到quick.next遇到大于x的值，则将slow.next到quick的元素插入到temphead之后，
         * 同时quick，slow指向quick.next
         * temphead则移动到插入的元素串的下一位，准备接收下一个插入串
         * **/
        while(quick != null){
            if((quick.next == null || quick.next.val >= x) && quick == slow){   //100000,4,4,1,3   x=2  ----这里是为了判断这种末尾大于x的情况
                quick = quick.next;                                             //对于前面的两个4和最后的3，都可以直接跳过
                slow = slow.next;                                               //注意这里如果最后一位小于x，则
                continue;                                                       //100000,4,2,2,3,1 x=2  ----末尾小于x则不会进入这个判断
            }
            if(quick.next != null && quick.next.val < x) {      //slow与quick锁定小于x的一段链表后，下面代码将这段链表加入temphead之后
                if(mark == 0) {
                    mark = 1;
                    slow = quick;
                    quick = quick.next;
                    continue;
                }else{
                    quick = quick.next;
                    continue;
                }
            }
            temp = slow.next;                   //对于100000，4，1，2，3，5 x=4   quick指向3，slow指向4，temp指向1，temp2指向5，temphead指向100000
            temp2 = quick.next;
            slow.next = quick.next;             //使4指向5
            quick.next = temphead.next;         //使3指向4
            temphead.next = temp;               //100000指向1
            temphead = quick;                   //temphead指向3
            quick = temp2;                      //quick，slow指向5
            slow = quick;
            mark = 0;
        }
        // while(head.next != null) {
        //     System.out.println(head.val);
        //     head = head.next;
        // }
        return head.next;
    }
}
