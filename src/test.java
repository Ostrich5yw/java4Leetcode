class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class test {
    public static void main(String[] args) {
        test t = new test();
        ListNode head = new ListNode(1);
        ListNode list = head;
        for(int i = 2;i <= 5;i ++){
            ListNode temp = new ListNode(i);
            list.next = temp;
            list = temp;
        }
        System.out.println(t.reverseBetween(head, 2, 4));
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = head;
        return head;
    }
}