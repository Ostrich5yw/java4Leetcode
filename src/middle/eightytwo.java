package middle;


class ListNode81 {
    int val;
    ListNode81 next;
    ListNode81(int x) { val = x; }
}
public class eightytwo {
    public static void main(String[] args) {
        eightytwo t = new eightytwo();
        int[] arr = new int[]{1 ,2, 3, 3, 3};
        ListNode81 head = new ListNode81(1);
        ListNode81 list = head;
        for(int i = 0;i < arr.length;i ++){
            ListNode81 temp = new ListNode81(arr[i]);
            list.next = temp;
            list = temp;
        }
        System.out.println(t.deleteDuplicates(head));
    }
    public ListNode81 deleteDuplicates(ListNode81 head) {
        if (head == null)
            return null;
        //为了判断第一个元素是否重复。所以我们需要引入头指针newhead，使得newhead.next = head;
        ListNode81 newhead = new ListNode81(Integer.MAX_VALUE);
        /**
         * slow指针指向首元素
         * quick指针指向第二元素，开始遍历
         * 当quick指针的值与slow指针相同，说明该元素有重复，将mark记为true。
         * slow表示当前元素，当quick走到与slow不同时，说明quick到了下一元素，此时判断mark，若为false，
         * 说明没有该元素重复元素，加到newhead之后。若为true，说明该元素有重复值，不加入newhead。
         *
         * **/
        ListNode81 quick = head.next;
        ListNode81 slow = head;
        newhead.next = head;
        head = newhead;             //head重新指向新的头节点。newhead负责构建新串，head负责返回新串
        boolean mark = false;
        while(quick != null){
            if(quick.val == slow.val){      //两元素相等，说明slow记录的元素有重复值，mark记为true
                mark = true;
                quick = quick.next;         //quick指向下一个，同时continue跳过之后的判断(遍历完当前slow的元素)
                continue;
            }
            if(!mark) {                     //quick与slow不等，并且mark也为false(即slow记录的元素没有重复值)
                newhead.next = slow;        //将其加入newhead
                newhead = newhead.next;
            }
            mark = false;                   //复位，再次开始下一个元素判断
            slow = quick;
            quick = quick.next;
        }
        if (!mark){                     //最后一个元素无法进入判断句，所以这里单独对最后一个元素做判断。
            newhead.next = slow;
        }else{
            newhead.next = null;
        }
//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
        return head.next;
    }
}