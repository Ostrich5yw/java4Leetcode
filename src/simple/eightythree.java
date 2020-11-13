package simple;

class ListNode83 {
    int val;
    ListNode83 next;
    ListNode83(int x) { val = x; }
}
public class eightythree {
    public static void main(String[] args) {
        eightythree t = new eightythree();
        int[] arr = new int[]{1 ,2, 3, 3, 3};
        ListNode83 head = new ListNode83(1);
        ListNode83 list = head;
        for(int i = 0;i < arr.length;i ++){
            ListNode83 temp = new ListNode83(arr[i]);
            list.next = temp;
            list = temp;
        }
        System.out.println(t.deleteDuplicates(head));
    }
    public ListNode83 deleteDuplicates(ListNode83 head) {
        if (head == null)
            return null;
        ListNode83 tt = head;
        while(tt.next != null){
            if(tt.val == tt.next.val){          //如果下一位与当前值一致
                tt.next = tt.next.next;         //则删除下一位
                continue;                       //有可能出现2个以上的连续，所以删除完不可以让tt后移，而应该等之后的重复值全部删除完才向后移
            }
            tt = tt.next;
        }
//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
        return head;
    }
}
