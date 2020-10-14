package simple;

class ListNode21 {
    int val;
    ListNode21 next;
    ListNode21(){}
    ListNode21(int val){
        this.val = val;
    }
    ListNode21(int val, ListNode21 next){
        this.val = val;
        this.next = next;
    }
}
public class twentyone {
    public static void main(String[] args) {
        twentyone t = new twentyone();
        ListNode21 list1 = new ListNode21(0);
        ListNode21 head1 = list1;
        for(int i = 1;i < 5;i ++){
            ListNode21 list2 = new ListNode21(i);
            list1.next = list2;
            list1 = list1.next;
        }

        ListNode21 list3 = new ListNode21(0);
        ListNode21 head2 = list3;
        for(int i = 2;i < 5;i ++){
            ListNode21 list4 = new ListNode21(i);
            list3.next = list4;
            list3 = list3.next;
        }
        ListNode21 l = t.mergeTwoLists(head1.next, head2.next);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        ListNode21 listnode = new ListNode21();
        ListNode21 head = listnode;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ListNode21 temp = new ListNode21(l1.val);
                listnode.next = temp;
                l1 = l1.next;
            }else{
                ListNode21 temp = new ListNode21(l2.val);
                listnode.next = temp;
                l2 = l2.next;
            }
            listnode = listnode.next;
        }
        while(l1 != null){
            ListNode21 temp = new ListNode21(l1.val);
            listnode.next = temp;
            listnode = listnode.next;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode21 temp = new ListNode21(l2.val);
            listnode.next = temp;
            listnode = listnode.next;
            l2 = l2.next;
        }
        return head.next;
    }
}

